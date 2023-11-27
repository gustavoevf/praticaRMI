import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    private Client() {}

    public static void main(String[] args) {

        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 9400);
            Calculadora stub = (Calculadora) registry.lookup("Calculadora");
            int respostaAdicao = stub.adicao(13, 20);
            System.out.println("13 + 20: " + respostaAdicao);
            int respostaSub = stub.subtracao(10, 20);
            System.out.println("10 - 20: " + respostaSub);
            int respostaMult = stub.multiplicacao(2, 20);
            System.out.println("2 * 20: " + respostaMult);
            double respostaDiv = stub.divisao(10, 20);
            System.out.println("10 / 20: " + respostaDiv);
        } catch (Exception e) {
            System.err.println("Exceção: " + e.toString());
            e.printStackTrace();
        }
    }
}