public class CartaoDeCredito {
    private String numero;
    private String nomeTitular;
    private String cpfTitular;
    private double limite;
    private double saldo;

    public CartaoDeCredito(String numero, String nomeTitular, String cpfTitular, double limite, double saldo) {
        this.numero = numero;
        this.nomeTitular = nomeTitular;
        this.cpfTitular = cpfTitular;
        this.limite = limite;
        this.saldo = saldo;
    }

    public String consultarSaldo() {
        return String.format("Saldo disponível: R$ %.2f", saldo);
    }

    public String consultarLimite() {
        return String.format("Limite total: R$ %.2f", limite);
    }

    public String realizarTransacao(double valor) {
        if (valor <= 0) return "Valor inválido para transação.";
        if (valor > (limite - saldo)) return "Transação negada: limite insuficiente.";
        saldo += valor;
        return String.format("Transação de R$ %.2f realizada com sucesso! Saldo atual: R$ %.2f", valor, saldo);
    }
}
