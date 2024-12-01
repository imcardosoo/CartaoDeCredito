import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o número do cartão:");
        String numero = scanner.nextLine();
        System.out.println("Informe o nome do titular:");
        String nomeTitular = scanner.nextLine();

        CartaoDeCredito cartao = new CartaoDeCredito(numero, nomeTitular);

        System.out.println("Selecione a opção de compra:");
        System.out.println("1. Compra básica");
        System.out.println("2. Compra com cashback");
        int opcao = scanner.nextInt();

        System.out.println("Informe o valor da compra:");
        double valor = scanner.nextDouble();

        if (opcao == 1) {
            System.out.println(cartao.realizarCompra(valor));
        } else if (opcao == 2) {
            System.out.println(cartao.realizarCompra(valor, true));
        } else {
            System.out.println("Opção inválida.");
        }
    }
}
