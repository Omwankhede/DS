import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String[] args) {
        try {
            // Create and export the first remote object
            ImplExample1 obj1 = new ImplExample1();
            Registry registry = LocateRegistry.createRegistry(1100);
            registry.bind("Hello1", obj1);

            // Create and export the second remote object
            ImplExample2 obj2 = new ImplExample2();
            // Use createRegistry() for the second registry
            Registry registry2 = LocateRegistry.createRegistry(1098); // Specify a different port if needed
            registry2.bind("Hello2", obj2);

            System.out.println("Server is ready!");

            // To close the ports when you are done
            // Unexport the remote objects

        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
