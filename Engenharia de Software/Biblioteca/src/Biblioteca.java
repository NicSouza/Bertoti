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

    private List<Associado> associados = new LinkedList<Associado>();
	
	public void cadastrarAssociado(Associado associado){
		associados.add(associado);
	}
	
	public List<Associado> buscarAssociadoPorNome(String nome){
		List<Associado> associadosEncontrados = new LinkedList<Associado>();
		for (Associado associado:associados){
            if(associado.getNome().equals(nome)){
                associadosEncontrados.add(associado);
            }   
        }    
        return associadosEncontrados;
	}

    public Associado buscarAssociadoPorId(int id){
        for(Associado associado:associados){
            if(associado.getId() == id){
                return associado;
            }
        }    
        return null;
    }

    public List<Associado> getAssociados(){
        return this.associados;
    }
}