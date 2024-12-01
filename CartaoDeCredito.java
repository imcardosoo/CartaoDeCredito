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

        public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getCpfTitular() {
        return cpfTitular;
    }

    public void setCpfTitular(String cpfTitular) {
        this.cpfTitular = cpfTitular;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String consultarSaldo() {
        return String.format("Saldo disponível: R$ %.2f", getSaldo());
    }

    public String consultarLimite() {
        return String.format("Limite total: R$ %.2f", getLimite());
    }

    public String realizarTransacao(double valor) {
        if (valor <= 0) return "Valor inválido para transação.";
        if (valor > (getLimite() - getSaldo())) return "Transação negada: limite insuficiente.";
        setSaldo(getSaldo() + valor);
        return String.format("Transação de R$ %.2f realizada com sucesso! Saldo atual: R$ %.2f", valor, getSaldo());
    }
}
