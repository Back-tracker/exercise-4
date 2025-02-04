import java.rmi.Naming;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {
        try {
            ChatInterface chat = (ChatInterface) Naming.lookup("rmi://192.168.230.128:5000/chatService");
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print("You: ");
                String message = scanner.nextLine();
                chat.sendMessage(message);
                
                String response = chat.receiveMessage();
                System.out.println("Server: " + response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
