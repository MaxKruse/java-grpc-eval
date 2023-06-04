import io.grpc.*;
import io.grpc.internal.GrpcUtil;
import services.UserService;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Application {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Starting Server!");
        int port = 50001;
        Server server = Grpc.newServerBuilderForPort(port, InsecureServerCredentials.create())
                .addService(new UserService())
                .build().start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down gRPC server!");
            try {
                server.shutdown().awaitTermination(10, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("gRPC server shut down!");
        }));

        System.out.println("Registered services: " + server.getServices().stream().map(s -> s.getServiceDescriptor().getName()).reduce((a, b) -> a + ", " + b).orElse("none"));


        System.out.println("Server started on port " + server.getPort() + "! Press CTRL+C to stop!");
        server.awaitTermination();
    }
}
