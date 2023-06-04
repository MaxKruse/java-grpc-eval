import io.grpc.*;
import org.jetbrains.annotations.NotNull;
import xyz.mkruse.sdk.*;
import xyz.mkruse.sdk.UserServiceGrpc.UserServiceBlockingStub;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Application {

    static void printChannelState(@NotNull ManagedChannel channel) {
        ConnectivityState state = channel.getState(true);
        System.out.println("Channel state: " + state);
    }

    static User stubPost(@NotNull UserServiceBlockingStub stub, @NotNull CreateUserRequest request ) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            CreateUserResponse response = stub.withWaitForReady().createUser(request);
            return response.getUser();
        } catch (StatusRuntimeException e) {
            System.out.println("Status: " + e.getStatus());
            System.out.println("Description: " + e.getStatus().getDescription());
            System.out.println("Cause: " + e.getCause());
            System.out.println("Message: " + e.getMessage());
            System.out.println("Trailers: " + e.getTrailers());
        }

        return User.getDefaultInstance();
    }

    static User stubGet(@NotNull UserServiceBlockingStub stub, @NotNull GetUserRequest request ) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        try {
            GetUserResponse response = stub.withWaitForReady().getUser(request);
            return response.getUser();
        } catch (StatusRuntimeException e) {
            System.out.println("Status: " + e.getStatus());
            System.out.println("Description: " + e.getStatus().getDescription());
            System.out.println("Cause: " + e.getCause());
            System.out.println("Message: " + e.getMessage());
            System.out.println("Trailers: " + e.getTrailers());
        }

        return  User.getDefaultInstance();
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting Client!");
        int port = 50001;
        String target = "localhost:" + port;

        ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create()).build();
        System.out.println("Channel created!");

        UserServiceBlockingStub stub = UserServiceGrpc.newBlockingStub(channel);
        System.out.println("Stub created!");
        printChannelState(channel);

        GetUserRequest request = GetUserRequest.newBuilder().setId( UUID.randomUUID().toString()).build();
        System.out.println("Request created: " + request);
        User user = stubGet(stub, request);

        // create a few users
        List<String> uuids = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            CreateUserRequest r = CreateUserRequest.newBuilder().setUser( User.newBuilder().setName("User " + i).build() ).build();
            User userResponse = stubPost(stub, r);
            System.out.println("Response received: " + userResponse);
            uuids.add(userResponse.getId());
        }

        // try getting some random UUIDs (like 5)
        for (int i = 0; i < 5; i++) {
            request = GetUserRequest.newBuilder().setId( UUID.randomUUID().toString() ).build();
            User userResponse = stubGet(stub, request);
            System.out.println("Response received: " + userResponse);
        }

        // try getting the uuids we have saved before
        for (int i = 0; i < 10; i++) {
            request = GetUserRequest.newBuilder().setId( uuids.get(i)).build();
            User r = stubGet(stub, request);
            System.out.println("Response received: " + r);
        }

        System.out.println("We are done!");

        channel.shutdownNow().awaitTermination(1, TimeUnit.SECONDS);
        System.out.println("cya");
    }
}
