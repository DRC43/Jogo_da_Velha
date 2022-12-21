import java.util.Scanner;

public class Principal {
    public Principal() {
    }

    public static void main(String[] args) {
        String letra = "#";
        Scanner ler = new Scanner(System.in);
        System.out.println("Qual o tamanho da escadinha?");
        int tamanho = ler.nextInt();

        for(int i = 1; i <= tamanho; ++i) {
            System.out.println(letra);
            letra = letra + "#";
        }

    }
}
