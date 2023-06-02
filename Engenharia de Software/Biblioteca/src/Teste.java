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

    @Test
    public void testBuscarLivroPorTituloInexistente() {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.cadastrarLivro(new Livro("Garota Exemplar", new Especificacao("Gillian Flynn", "Intrínseca")));

        Livro livroEncontrado = biblioteca.buscarLivroPorTitulo("Objetos Cortantes");

        assertNull(livroEncontrado);
    }

    @Test
    public void testBuscarLivroPorEspecificacaoInexistente() {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.cadastrarLivro(new Livro("Garota Exemplar", new Especificacao("Gillian Flynn", "Intrínseca")));
        biblioteca.cadastrarLivro(new Livro("A Paciente Silenciosa", new Especificacao("Alex Michaelides", "Record")));

        List<Livro> livrosEncontrados = biblioteca.buscarLivroPorEspecificação(new Especificacao("Taylor Jenkins Reid", "Paralela"));

        assertEquals(0, livrosEncontrados.size());
    }

    @Test
    public void testBuscarAssociadoPorNomeInexistente() {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.cadastrarAssociado(new Associado("Nicole", 1));
        biblioteca.cadastrarAssociado(new Associado("Bertoti", 2));

        List<Associado> associadosEncontrados = biblioteca.buscarAssociadoPorNome("Alice");

        assertEquals(0, associadosEncontrados.size());
    }

    @Test
    public void testBuscarAssociadoPorIdInexistente() {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.cadastrarAssociado(new Associado("Nicole", 1));
        biblioteca.cadastrarAssociado(new Associado("Bertoti", 2));

        Associado associadoEncontrado = biblioteca.buscarAssociadoPorId(3);

        assertNull(associadoEncontrado);
    }

    @Test
    public void testCadastrarLivro() {
        Biblioteca biblioteca = new Biblioteca();
        Livro livro = new Livro("Harry Potter e a Pedra Filosofal", new Especificacao("J.K. Rowling", "Rocco"));

        biblioteca.cadastrarLivro(livro);

        List<Livro> livros = biblioteca.getLivros();
        assertEquals(1, livros.size());
        assertEquals(livro, livros.get(0));
    }

    @Test
    public void testCadastrarAssociado() {
        Biblioteca biblioteca = new Biblioteca();
        Associado associado = new Associado("João", 1);

        biblioteca.cadastrarAssociado(associado);

        List<Associado> associados = biblioteca.getAssociados();
        assertEquals(1, associados.size());
        assertEquals(associado, associados.get(0));
    }

    @Test
    public void testBuscarAssociadoPorId() {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.cadastrarAssociado(new Associado("Maria", 1));
        biblioteca.cadastrarAssociado(new Associado("Pedro", 2));

        Associado associadoEncontrado = biblioteca.buscarAssociadoPorId(2);

        assertNotNull(associadoEncontrado);
        assertEquals("Pedro", associadoEncontrado.getNome());
    }

    @Test
    public void testBuscarLivroPorEspecificacaoAutorInexistente() {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.cadastrarLivro(new Livro("Dom Casmurro", new Especificacao("Machado de Assis", "Editora XYZ")));

        List<Livro> livrosEncontrados = biblioteca.buscarLivroPorEspecificação(new Especificacao("J.K. Rowling", "Editora XYZ"));

        assertEquals(0, livrosEncontrados.size());
    }

}