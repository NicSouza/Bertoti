package com.labIII.bibiliotecabackend.repository;

import com.labIII.bibiliotecabackend.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
