package br.com.aceleradev.biblioteca.services;

import br.com.aceleradev.biblioteca.models.Categoria;

public interface CategoriaService {

    Categoria findById(Long id);

    Categoria save(Categoria categoria);

}
