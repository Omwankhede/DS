import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client1 {
    public static void main(String[] args) {
        System.out.println("Client1 sending request to Server");
        try {
            // Set the registry host and port
            String registryHost = "localhost"; // Replace with the actual host where the RMI registry is running
            int registryPort = 1100; // Replace with the actual port of the RMI registry

            // Get the registry
            Registry registry = LocateRegistry.getRegistry(registryHost, registryPort);

            // Look up the remote object by its binding name
            Hello1 stub1 = (Hello1) registry.lookup("Hello1");

            // Call the remote method
            stub1.message();
        } catch (Exception e) {
            System.err.println("Client1 exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
