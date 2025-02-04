import java.rmi.Naming;

public class RMIServer {
    public static void main(String[] args) {
        try {
            MyRemoteInterface remoteObject = new MyRemoteImpl();
            Naming.rebind("rmi://localhost:5000/factorialService", remoteObject);
            System.out.println("Server is ready.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
