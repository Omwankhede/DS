import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client2 {
    public static void main(String[] args) {
        System.out.println("Client2 sending request to Server");
        try {
            // Set the registry host and port

            String registryHost = "localhost"; // Replace with the actual host where the RMI registry is running
            int registryPort = 1098; // Replace with the actual port of the RMI registry

            // Get the registry
            Registry registry = LocateRegistry.getRegistry(registryHost, registryPort);

            // Look up the remote object by its binding name
            Hello2 stub2 = (Hello2) registry.lookup("Hello2");

            // Call the remote method
            stub2.message();
        } catch (Exception e) {
            System.err.println("Client2 exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
