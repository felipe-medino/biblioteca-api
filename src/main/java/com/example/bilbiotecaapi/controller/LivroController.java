package com.example.bilbiotecaapi.controller;

import com.example.bilbiotecaapi.model.Livro;
import com.example.bilbiotecaapi.repository.LivroRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroRepository repository;

    public LivroController(LivroRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Livro> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Livro buscar(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Livro criar(@RequestBody Livro livro) {
        return repository.save(livro);
    }

    @PutMapping("/{id}")
    public Livro atualizar(@PathVariable Long id, @RequestBody Livro livro) {
        Livro existente = repository.findById(id).orElse(null);

        if (existente == null) {
            return null;
        }

        existente.setTitulo(livro.getTitulo());
        existente.setAutor(livro.getAutor());
        existente.setAnoPublicacao(livro.getAnoPublicacao());

        return repository.save(existente);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        repository.deleteById(id);
    }
}