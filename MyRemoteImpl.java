import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemoteInterface {

    protected MyRemoteImpl() throws RemoteException {
        super();
    }

    @Override
    public long factorial(int number) throws RemoteException {
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        System.out.println("client:"+number);
        return result;
    }
}
