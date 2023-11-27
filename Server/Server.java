import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Calculadora {

    public Server() {
    }

    public int adicao(int x, int y) {
        return x + y;
    }

    public int subtracao(int x, int y) {
        return x - y;
    }

    public int multiplicacao(int x, int y) {
        return x * y;
    }

    public double divisao(int x, int y) throws RemoteException {
        if (y == 0) {
            throw new RemoteException("O divisor não pode ser igual a 0");
        }

        return (double) x / y;
    }

    public static void main(String args[]) {

        try {
            // Create and export a remote object
            Server obj = new Server();
            Calculadora stub = (Calculadora) UnicastRemoteObject.exportObject(obj, 0);

            // Register the remote object with a Java RMI registry
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9400);
            registry.bind("Calculadora", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}