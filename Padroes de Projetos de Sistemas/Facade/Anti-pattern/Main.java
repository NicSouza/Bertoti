import java.util.HashMap;
import java.util.Map;

// Subsistema - Pedido
class Pedido {
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

// Subsistema - Pagamento
class Pagamento {
    public boolean processarPagamento(double valor) {
        System.out.println("Processando pagamento de R$" + valor);
        // Simulação de processamento de pagamento
        return true;
    }
}

// Subsistema - Estoque
class Estoque {
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

// Fat Facade (antipattern)
class CafeteriaFacade {
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
    
    // Exemplo de adição de responsabilidade extra na Fachada (antipattern)
    public void gerarRelatorioDeVendas() {
        // Lógica para gerar relatório de vendas
        // Aqui a fachada está acumulando responsabilidades que não deveriam ser dela
        System.out.println("Gerando relatório de vendas...");
    }
    
    // Exemplo de adição de responsabilidade extra na Fachada (antipattern)
    public void gerarFaturaMensal() {
        // Lógica para gerar fatura mensal
        // Novamente, responsabilidades adicionais na fachada
        System.out.println("Gerando fatura mensal...");
    }
}

// Classe Principal (Main)
public class Main {
    public static void main(String[] args) {
        CafeteriaFacade cafeteriaFacade = new CafeteriaFacade();
        
        // Realizar um pedido de 2 cafés por R$10,00 cada
        cafeteriaFacade.realizarPedido("Café", 2, 20.00);
        
        // Tentar realizar um pedido de 6 bolos por R$15,00 cada (deve falhar por falta de estoque)
        cafeteriaFacade.realizarPedido("Bolo", 6, 90.00);
        
        // Realizar um pedido de 1 bolo por R$15,00
        cafeteriaFacade.realizarPedido("Bolo", 1, 15.00);
        
        // Exemplo de uso das funcionalidades adicionais no antipattern
        cafeteriaFacade.gerarRelatorioDeVendas();
        cafeteriaFacade.gerarFaturaMensal();
    }
}
