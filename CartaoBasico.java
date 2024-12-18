public class CartaoBasico extends CartaoDeCredito {

    public CartaoBasico(String numero, Cliente cliente) {
        super(numero, cliente);  

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
        System.out.println("Compra realizada de R$ " + valor + ". Saldo atual: R$ " + getSaldo());

        Transacao transacao = new Transacao(new Date(), (float) valor, descricao);
        
    }
}