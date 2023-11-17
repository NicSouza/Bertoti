package com.labIII.bibiliotecabackend.controller;


import com.labIII.bibiliotecabackend.exception.LivroNotFoundException;
import com.labIII.bibiliotecabackend.model.Livro;
import com.labIII.bibiliotecabackend.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3002")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @PostMapping("/livro")
    Livro newLivro(@RequestBody Livro newLivro){
        return livroRepository.save(newLivro);
    }

    @GetMapping("/livros")
    List<Livro> getAllLivros(){
        return livroRepository.findAll();
    }

    @GetMapping("/livro/{id}")
    Livro getLivroById(@PathVariable Long id){
        return livroRepository.findById(id)
                .orElseThrow(() -> new LivroNotFoundException(id));
    }

    @PutMapping("/livro/{id}")
    Livro updateLivro(@RequestBody Livro newLivro, @PathVariable Long id){
        return livroRepository.findById(id)
                .map(livro -> {
                    livro.setTitulo(newLivro.getTitulo());
                    livro.setAutor(newLivro.getAutor());
                    livro.setEditora(newLivro.getEditora());
                    return livroRepository.save(livro);
                }).orElseThrow(()->new LivroNotFoundException(id));
    }

    @DeleteMapping("/livro/{id}")
    String deleteLivro(@PathVariable Long id){
        if(!livroRepository.existsById(id)){
            throw new LivroNotFoundException(id);
        }
        livroRepository.deleteById(id);
        return "O livro com o id "+id+" foi deletado com sucesso.";
    }

}
