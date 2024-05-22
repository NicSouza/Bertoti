import java.util.HashMap;
import java.util.Map;

public class Estoque {
    private Map<String, Integer> produtos;

    public Estoque() {
        produtos = new HashMap<>();
        produtos.put("Café", 10);
        produtos.put("Bolo", 5);
    }

    public boolean verificarDisponibilidade(String produto, int quantidade) {
        return produtos.getOrDefault(produto, 0) >= quantidade;
    }

    public void atualizarEstoque(String produto, int quantidade) {
        int novoEstoque = produtos.get(produto) - quantidade;
        produtos.put(produto, novoEstoque);
        System.out.println("Estoque atualizado: " + produto + " - " + novoEstoque + " restantes.");
    }
}
