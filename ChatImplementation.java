import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.util.Scanner;

public class ChatImplementation extends UnicastRemoteObject implements ChatInterface {
    private String lastMessage = "";

    protected ChatImplementation() throws RemoteException {
        super();
    }

    @Override
    public void sendMessage(String message) throws RemoteException {
        System.out.println("Client: " + message);
        lastMessage = message;
    }

    @Override
    public String receiveMessage() throws RemoteException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Server: ");
        String response = scanner.nextLine();
        lastMessage = response;
        return response;
    }
}
