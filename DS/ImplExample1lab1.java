import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ImplExample1 extends UnicastRemoteObject implements Hello1 {
    public ImplExample1() throws RemoteException {
        // Constructor
    }

    @Override
    public void message() throws RemoteException {
        System.out.println("Hello Client1 from Server");
    }

    // Additional methods specific to Client1, if needed
}
