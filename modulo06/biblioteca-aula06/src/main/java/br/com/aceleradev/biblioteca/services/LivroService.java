package br.com.aceleradev.biblioteca.services;

import br.com.aceleradev.biblioteca.models.Livro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LivroService {
    Livro save(Livro livro);

    Page<Livro> findAll(Pageable pageable);

    Livro findById(Long id);

    void update(Long id, Livro livro);

    void delete(Long id);
}
