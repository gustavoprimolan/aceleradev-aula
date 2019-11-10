package br.com.aceleradev.biblioteca.services;

import br.com.aceleradev.biblioteca.models.Livro;

import java.util.List;

public interface LivroService {
    Livro save(Livro livro);

    List<Livro> findAll();

    Livro findById(Long id);
}
