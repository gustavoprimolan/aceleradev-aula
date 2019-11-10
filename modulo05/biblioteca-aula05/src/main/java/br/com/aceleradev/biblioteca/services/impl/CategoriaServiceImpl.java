package br.com.aceleradev.biblioteca.services.impl;

import br.com.aceleradev.biblioteca.models.Categoria;
import br.com.aceleradev.biblioteca.repositories.CategoriaRepository;
import br.com.aceleradev.biblioteca.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public Categoria findById(Long id) {
        return categoriaRepository.findById(id).get();
    }

    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

}
