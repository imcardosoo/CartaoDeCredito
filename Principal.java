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

        System.out.println("Deseja criar o cartão com limite e cashback personalizados?");
        System.out.println("1. Não (Limite padrão)");
        System.out.println("2. Sim");
        int opcao = scanner.nextInt();

        CartaoDeCredito cartao;

        if (opcao == 2) {
            System.out.println("Informe o limite do cartão:");
            double limite = scanner.nextDouble();
            System.out.println("Informe a taxa de cashback (por exemplo, 0.05 para 5%):");
            double cashback = scanner.nextDouble();
            cartao = new CartaoDeCredito(numero, cliente, limite, cashback);
        } else {
            cartao = new CartaoDeCredito(numero, cliente);
        }

        System.out.println("Selecione a opção de compra:");
        System.out.println("1. Compra básica");
        System.out.println("2. Compra com cashback");
        int compraOpcao = scanner.nextInt();

        System.out.println("Informe o valor da compra:");
        double valor = scanner.nextDouble();

        if (compraOpcao == 1) {
            System.out.println(cartao.realizarCompra(valor));
        } else if (compraOpcao == 2) {
            System.out.println(cartao.realizarCompra(valor, true));
        } else {
            System.out.println("Opção inválida.");
        }
    }
}