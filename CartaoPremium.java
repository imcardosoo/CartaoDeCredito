public class CartaoPremium extends CartaoDeCredito {

    public CartaoPremium(String numero, Cliente cliente) {
        super(numero, cliente, 2000.00, 0.05);  // Limite extra e taxa de cashback de 5%
    }

    @Override
    public void realizarCompra(double valor, boolean comCashback, String descricao) {
        if (valor <= 0) {
            System.out.println("Valor inválido!");
            return;
        }
        if (valor > getLimite() - getSaldo()) {
            System.out.println("Saldo insuficiente!");
            return;
        }
        setSaldo(getSaldo() + valor);
        if (comCashback) {
            double cashback = valor * 0.05;  
            setSaldo(getSaldo() + cashback);
            System.out.println("Compra com cashback realizada de R$ " + valor + ". Cashback de R$ " + cashback + ". Saldo atual: R$ " + getSaldo());
        } else {
            System.out.println("Compra realizada de R$ " + valor + ". Saldo atual: R$ " + getSaldo());
        }

        Transacao transacao = new Transacao(new Date(), (float) valor, descricao);
        
    }
}