import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número do cartão: ");
        String numero = scanner.nextLine();

        System.out.print("Digite o nome do titular: ");
        String nomeTitular = scanner.nextLine();

        System.out.print("Digite o CPF do titular: ");
        String cpfTitular = scanner.nextLine();

        System.out.print("Digite o limite do cartão: ");
        double limite = scanner.nextDouble();

        CartaoDeCredito cartao = new CartaoDeCredito(numero, nomeTitular, cpfTitular, limite, 0.0);

        int opcao;
        do {
            System.out.println("\nMenu de Opções:");
            System.out.println("1 - Realizar Transação");
            System.out.println("2 - Consultar Limite");
            System.out.println("3 - Consultar Saldo");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor da transação: ");
                    double valor = scanner.nextDouble();
                    System.out.println(cartao.realizarTransacao(valor));
                    break;
                case 2:
                    System.out.println(cartao.consultarLimite());
                    break;
                case 3:
                    System.out.println(cartao.consultarSaldo());
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
