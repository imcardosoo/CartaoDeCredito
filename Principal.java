public class Principal {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("João", "123.456.789-00", "12345678000199", "joao@email.com", "987654321");

        CartaoDeCredito cartaoBasico = new CartaoBasico("1234", cliente);
        CartaoDeCredito cartaoPremium = new CartaoPremium("5678", cliente);
        CartaoDeCredito cartaoEmpresarial = new CartaoEmpresarial("91011", cliente);

        cartaoBasico.realizarCompra(500, false, "Compra básica");
        cartaoPremium.realizarCompra(1000, true, "Compra com cashback");
        cartaoEmpresarial.realizarCompra(3000, false, "Compra empresarial");

        cartaoBasico.exibirHistorico();
        cartaoPremium.exibirHistorico();
        cartaoEmpresarial.exibirHistorico();
    }
}