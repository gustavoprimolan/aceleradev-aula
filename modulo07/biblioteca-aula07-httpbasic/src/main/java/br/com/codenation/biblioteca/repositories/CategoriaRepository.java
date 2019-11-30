package br.com.codenation.biblioteca.repositories;

import br.com.codenation.biblioteca.models.Categoria;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
    List<Categoria> findAll();
}
