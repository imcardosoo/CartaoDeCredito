public class CartaoDeCredito {
    private String numero;
    private double limite;
    private double saldo;
    private double taxaCashback;
    private Cliente cliente;

    public CartaoDeCredito(String numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.limite = 1000.00;
        this.saldo = 0.00;
        this.taxaCashback = 0.05;
    }

    public CartaoDeCredito(String numero, Cliente cliente, double limite, double taxaCashback) {
        this.numero = numero;
        this.cliente = cliente;
        this.limite = limite;
        this.saldo = 0.00;
        this.taxaCashback = taxaCashback;
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

    public String realizarCompra(double valor) {
        if (valor <= 0) {
            return "Valor inválido!";
        }
        if (valor > limite - saldo) {
            return "Saldo insuficiente!";
        }
        saldo += valor;
        return "Compra realizada de R$ " + valor + ". Saldo atual: R$ " + saldo;
    }

    public String realizarCompra(double valor, boolean comCashback) {
        if (valor <= 0) {
            return "Valor inválido!";
        }
        if (valor > limite - saldo) {
            return "Saldo insuficiente!";
        }
        saldo += valor;
        if (comCashback) {
            double cashback = valor * taxaCashback;
            saldo += cashback;
            return "Compra com cashback realizada de R$ " + valor + ". Cashback de R$ " + cashback + ". Saldo atual: R$ " + saldo;
        }
        return "Compra realizada de R$ " + valor + ". Saldo atual: R$ " + saldo;
    }
}