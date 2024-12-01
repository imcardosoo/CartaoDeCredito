import java.util.ArrayList;
import java.util.Date;

public class CartaoDeCredito {
    private String numero;
    private double limite;
    private double saldo;
    private double taxaCashback;
    private Cliente cliente;
    private ArrayList<Transacao> historicoDeTransacoes;

    public CartaoDeCredito(String numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.limite = 1000.00;  
        this.saldo = 0.00;
        this.taxaCashback = 0.0;  
        this.historicoDeTransacoes = new ArrayList<>();
    }

    public CartaoDeCredito(String numero, Cliente cliente, double limite, double taxaCashback) {
        this.numero = numero;
        this.cliente = cliente;
        this.limite = limite;
        this.saldo = 0.00;
        this.taxaCashback = taxaCashback;
        this.historicoDeTransacoes = new ArrayList<>();
    }

    public void realizarCompra(double valor, boolean comCashback, String descricao) {
        if (valor <= 0) {
            System.out.println("Valor inválido!");
            return;
        }
        if (valor > limite - saldo) {
            System.out.println("Saldo insuficiente!");
            return;
        }
        saldo += valor;
        if (comCashback && taxaCashback > 0) {
            double cashback = valor * taxaCashback;
            saldo += cashback;
            System.out.println("Compra com cashback realizada de R$ " + valor + ". Cashback de R$ " + cashback + ". Saldo atual: R$ " + saldo);
        } else {
            System.out.println("Compra realizada de R$ " + valor + ". Saldo atual: R$ " + saldo);
        }

        Transacao transacao = new Transacao(new Date(), (float) valor, descricao);
        historicoDeTransacoes.add(transacao);
    }

    public void exibirHistorico() {
        if (historicoDeTransacoes.isEmpty()) {
            System.out.println("Nenhuma transação realizada.");
            return;
        }
        for (Transacao t : historicoDeTransacoes) {
            System.out.println("Data: " + t.getData() + ", Valor: R$ " + t.getValor() + ", Descrição: " + t.getDescricao());
        }
    }

    // Getters e Setters
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
}