package com.example.bilbiotecaapi.repository;

import com.example.bilbiotecaapi.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}