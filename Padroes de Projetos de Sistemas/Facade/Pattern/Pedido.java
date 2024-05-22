public class Pedido {
    private String produto;
    private int quantidade;

    public Pedido(String produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public String getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void mostrarDetalhes() {
        System.out.println("Pedido: " + quantidade + "x " + produto);
    }
}
