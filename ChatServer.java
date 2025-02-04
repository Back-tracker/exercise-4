import java.rmi.Naming;

public class ChatServer {
    public static void main(String[] args) {
        try {
            ChatImplementation chat = new ChatImplementation();
            Naming.rebind("rmi://localhost:5000/chatService", chat);
            System.out.println("Chat Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
