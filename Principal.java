import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o nome do cliente:");
        String nome = scanner.nextLine();
        System.out.println("Informe o CPF do cliente:");
        String cpf = scanner.nextLine();
        System.out.println("Informe o CNPJ do cliente (caso tenha, senão deixe em branco):");
        String cnpj = scanner.nextLine();
        System.out.println("Informe o email do cliente:");
        String email = scanner.nextLine();
        System.out.println("Informe o telefone do cliente:");
        String telefone = scanner.nextLine();

        Cliente cliente = new Cliente(nome, cpf, cnpj, email, telefone);

        System.out.println("Informe o número do cartão:");
        String numero = scanner.nextLine();

        CartaoDeCredito cartao = new CartaoDeCredito(numero, cliente);

        System.out.println("Deseja realizar uma compra?");
        System.out.println("1. Sim");
        System.out.println("2. Não");
        int opcaoCompra = scanner.nextInt();

        if (opcaoCompra == 1) {
            System.out.println("Informe o valor da compra:");
            double valor = scanner.nextDouble();
            scanner.nextLine();  // Limpar o buffer de entrada

            System.out.println("Deseja aplicar cashback? (true/false):");
            boolean comCashback = scanner.nextBoolean();
            scanner.nextLine();  // Limpar o buffer de entrada

            System.out.println("Informe a descrição da compra:");
            String descricao = scanner.nextLine();

            cartao.realizarCompra(valor, comCashback, descricao);
        }

        System.out.println("Deseja ver o histórico de transações?");
        System.out.println("1. Sim");
        System.out.println("2. Não");
        int opcaoHistorico = scanner.nextInt();

        if (opcaoHistorico == 1) {
            cartao.exibirHistorico();
        }

        scanner.close();
    }
}