import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class Teste {
    
    @Test
    public void test(){

        Biblioteca biblioteca = new Biblioteca();

        assertEquals(biblioteca.getLivros().size(), 0);

        biblioteca.cadastrarLivro(new Livro("Garota Exemplar", new Especificacao("Gillian Flynn", "Intrínseca")));
        biblioteca.cadastrarLivro(new Livro("Objetos Cortantes", new Especificacao("Gillian Flynn", "Intrínseca")));
        biblioteca.cadastrarLivro(new Livro("A Paciente Silenciosa", new Especificacao("Alex Michaelides", "Record")));
        biblioteca.cadastrarLivro(new Livro("Os sete maridos de Evelyn Hugo", new Especificacao("Taylor Jenkins Reid", "Paralela")));
        biblioteca.cadastrarLivro(new Livro("A guerra dos tronos: As crônicas de gelo e fogo", new Especificacao("George R. R. Martin", "Leya")));
        biblioteca.cadastrarLivro(new Livro("Verity", new Especificacao("Collen Hoover", "Galera")));
        biblioteca.cadastrarLivro(new Livro("O iluminado", new Especificacao("Stephen King", "Suma")));
        biblioteca.cadastrarLivro(new Livro("Bom dia Verônica", new Especificacao("Andrea Killmore", "Leya")));

        assertEquals(biblioteca.getLivros().size(), 8);

        Livro livroEncontrado = biblioteca.buscarLivroPorTitulo("Garota Exemplar");

        assertEquals(livroEncontrado.getEspec().getAutor(), "Gillian Flynn");

        List<Livro> livrosEncontrados = biblioteca.buscarLivroPorEspecificação(new Especificacao("Gillian Flynn", "Intrínseca"));
        
        assertEquals(biblioteca.getAssociados().size(), 0);

        biblioteca.cadastrarAssociado(new Associado("Nicole", 1));
        biblioteca.cadastrarAssociado(new Associado("Bertoti", 2));

        assertEquals(biblioteca.getAssociados().size(), 2);

        List<Associado> associadosEncontrados = biblioteca.buscarAssociadoPorNome("Nicole");

        assertEquals(associadosEncontrados.get(0).getId(), 1);
    }
}
