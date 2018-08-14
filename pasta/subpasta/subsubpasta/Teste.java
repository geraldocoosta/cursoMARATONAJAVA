import java.io.Console;

public class Teste {

    public static void main(String[] args) {
        Console c = System.console();
        char[] pw = c.readPassword("%s", "pw: ");
        for (char caractere : pw) {
            System.out.print(caractere);
        }
        c.format("\n");

        String texto;

        while (true) {
            texto = c.readLine("%s", "\nDigite: ");
            c.format("Esse texto %s foi digitado", texto);

        }

    }

    
}