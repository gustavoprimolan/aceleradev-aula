package br.com.codenation.biblioteca.services;

import br.com.codenation.biblioteca.models.Categoria;


public interface CategoriaService {

    Categoria findById(Long id);

    Categoria save(Categoria categoria);
}
