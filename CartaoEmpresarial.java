public class CartaoEmpresarial extends CartaoDeCredito {

    public CartaoEmpresarial(String numero, Cliente cliente) {
        super(numero, cliente, 5000.00, 0.0);  
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
        System.out.println("Compra empresarial realizada de R$ " + valor + ". Parcelamento sem juros! Saldo atual: R$ " + getSaldo());

        Transacao transacao = new Transacao(new Date(), (float) valor, descricao);
        
    }
}