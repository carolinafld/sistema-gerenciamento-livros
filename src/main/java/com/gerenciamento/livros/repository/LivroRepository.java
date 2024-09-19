    package com.gerenciamento.livros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gerenciamento.livros.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
