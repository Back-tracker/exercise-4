import java.rmi.Naming;
import java.util.Scanner;

public class RMIClient {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a number to calculate its factorial: ");
            int number = scanner.nextInt();
            MyRemoteInterface remoteObject = (MyRemoteInterface) Naming.lookup("rmi://192.168.230.128:5004/factorialService");
            long result = remoteObject.factorial(number);
            System.out.println("Factorial of " + number + " is: " + result);
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
