import java.util.ArrayList;
import java.util.Date;

public class CartaoDeCredito {
    private String numero;
    private double limite;
    private double saldo;
    private Cliente cliente;
    private List<Transacao> historicoDeTransacoes;

    public CartaoDeCredito(String numero, Cliente cliente) {
        this.numero = numero;
        this.limite = 1000.0;
        this.saldo = 0.0;
        this.cliente = cliente;
        this.historicoDeTransacoes = new ArrayList<>();
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Transacao> getHistoricoDeTransacoes() {
        return historicoDeTransacoes;
    }

    public String consultarSaldo() {
        return String.format("Saldo disponível: R$ %.2f", saldo);
    }

    public String consultarLimite() {
        return String.format("Limite total: R$ %.2f", limite);
    }

    public String realizarCompra(double valor) {
        if (valor > (limite - saldo)) {
            return "Transação negada: limite insuficiente.";
        }
        saldo += valor;
        Transacao transacao = new Transacao(new Date(), valor, "Compra realizada");
        historicoDeTransacoes.add(transacao);
        return String.format("Compra de R$ %.2f realizada com sucesso!", valor);
    }

    public void exibirHistorico() {
        for (Transacao transacao : historicoDeTransacoes) {
            System.out.println(transacao);
        }
    }
}

