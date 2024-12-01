import java.util.Date;

public class Transacao {
    private Date data;
    private double valor;
    private String descricao;

    public Transacao(Date data, double valor, String descricao) {
        this.data = data;
        this.valor = valor;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return String.format("Data: %s | Valor: R$ %.2f | Descrição: %s", data, valor, descricao);
    }
}