import java.util.LinkedList;
import java.util.List;

public class Biblioteca {

	private List<Livro> livros = new LinkedList<Livro>();
	
	public void cadastrarLivro(Livro livro){
		livros.add(livro);
	}
	public List<Livro> buscarLivroPorEspecificação(Especificacao espec){
		List<Livro> livrosEncontrados = new LinkedList<Livro>();
		for (Livro livro:livros){
            if (livro.getEspec().comparar(espec)) livrosEncontrados.add(livro);
        }
        return livrosEncontrados;
	}

    public Livro buscarLivroPorTitulo(String titulo){
        for(Livro livro:livros){
            if(livro.getTitulo().equals(titulo)){
                return livro;
            }
        }
        return null;
    }

    public List<Livro> getLivros(){
        return this.livros;
    }
}
