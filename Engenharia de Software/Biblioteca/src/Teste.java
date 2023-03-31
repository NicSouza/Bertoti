import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class Teste {
    
    @Test
    public void test(){

        Biblioteca biblioteca = new Biblioteca();

        assertEquals(biblioteca.getLivros().size(), 0);

        biblioteca.cadastrarLivro(new Livro("Garota Exemplar", new Especificacao("Gillian Flynn", "Intrínseca")));
        biblioteca.cadastrarLivro(new Livro("A Paciente Silenciosa", new Especificacao("Alex Michaelides", "Record")));

        assertEquals(biblioteca.getLivros().size(), 2);

        Livro livroEncontrado = biblioteca.buscarLivroPorTitulo("Garota Exemplar");

        assertEquals(livroEncontrado.getEspec().getAutor(), "Gillian Flynn");

        List<Livro> livrosEncontrados = biblioteca.buscarLivroPorEspecificação(new Especificacao("Gillian Flynn", "Intrínseca"));
        
        assertEquals(livrosEncontrados.get(0).getEspec().getAutor(), "Gillian Flynn");
    }
}
