import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ImplExample2 extends UnicastRemoteObject implements Hello2 {
    public ImplExample2() throws RemoteException {
        // Constructor
    }

    @Override
    public void message() throws RemoteException {
        System.out.println("Hello Client2 from Server");
    }

    // Additional methods specific to Client2, if needed
}

