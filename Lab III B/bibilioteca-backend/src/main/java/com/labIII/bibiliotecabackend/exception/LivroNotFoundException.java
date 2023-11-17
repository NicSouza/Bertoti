package com.labIII.bibiliotecabackend.exception;

public class LivroNotFoundException extends RuntimeException{
    public LivroNotFoundException(Long id){
        super("Não foi possível encontrar o livro com o id:"+id);
    }
}
