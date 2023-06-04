package services;

import io.grpc.stub.StreamObserver;
import xyz.mkruse.sdk.*;
import xyz.mkruse.sdk.UserServiceGrpc.UserServiceImplBase;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserService extends UserServiceImplBase {
    private final Map<String, User> users;

    public UserService() {
        this.users = new HashMap<>();
    }

    @Override
    public void getUser(GetUserRequest request, StreamObserver<GetUserResponse> responseObserver) {
        String userId = request.getId();

        System.out.println("Trying to get userid " + userId);

        User user = users.get(userId);
        if (user != null) {
            responseObserver.onNext(GetUserResponse.newBuilder().setUser(user).build());
        } else {
            responseObserver.onNext(GetUserResponse.getDefaultInstance());
        }
        responseObserver.onCompleted();
    }

    @Override
    public void createUser(CreateUserRequest request, StreamObserver<CreateUserResponse> responseObserver) {
        User user = request.getUser();
        String userId = UUID.randomUUID().toString();
        user = user.toBuilder().setId(userId).build();
        users.put(userId, user);
        responseObserver.onNext(CreateUserResponse.newBuilder().setUser(user).build());
        responseObserver.onCompleted();
    }
}
