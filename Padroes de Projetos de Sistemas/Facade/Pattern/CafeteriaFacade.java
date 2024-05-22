public class CafeteriaFacade {
    private Pedido pedido;
    private Pagamento pagamento;
    private Estoque estoque;

    public CafeteriaFacade() {
        this.pagamento = new Pagamento();
        this.estoque = new Estoque();
    }

    public void realizarPedido(String produto, int quantidade, double valor) {
        if (estoque.verificarDisponibilidade(produto, quantidade)) {
            pedido = new Pedido(produto, quantidade);
            pedido.mostrarDetalhes();
            
            if (pagamento.processarPagamento(valor)) {
                estoque.atualizarEstoque(produto, quantidade);
                System.out.println("Pedido realizado com sucesso!");
            } else {
                System.out.println("Falha no pagamento.");
            }
        } else {
            System.out.println("Produto indisponível em estoque.");
        }
    }
}

