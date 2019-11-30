package br.com.codenation.biblioteca.services.impl;

import br.com.codenation.biblioteca.exceptions.ResourceNotFoundException;
import br.com.codenation.biblioteca.models.Categoria;
import br.com.codenation.biblioteca.models.Livro;
import br.com.codenation.biblioteca.repositories.LivroRepository;
import br.com.codenation.biblioteca.services.CategoriaService;
import br.com.codenation.biblioteca.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class LivroServiceImpl implements LivroService {

    private final LivroRepository livroRepository;
    private final CategoriaService categoriaService;

    @Autowired
    public LivroServiceImpl(LivroRepository livroRepository, CategoriaService categoriaService) {
        this.livroRepository = livroRepository;
        this.categoriaService = categoriaService;
    }

    @Transactional
    @Override
    public Livro save(Livro livro) {
        livro.setIdAsNull();
        preencheCategorias(livro);
        return livroRepository.save(livro);
    }

    @Override
    public Page<Livro> findAll(Pageable pageable) {
        return livroRepository.findAll(pageable);
    }

    @Override
    public Livro findById(Long id) {
        return livroRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Livro nao encontrado"));
    }

    @Transactional
    @Override
    public void update(Long id, Livro livro) {
        Livro livroPersistido = findById(id);
        livroPersistido.replace(livro);
        preencheCategorias(livroPersistido);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        livroRepository.deleteById(id);
    }

    private void preencheCategorias(Livro livro) {
        if(livro.isCategoriasEmpty()) return;

        List<Categoria> persistedCategorias = new ArrayList<>();
        for(Categoria categoria : livro.getCategorias()) {
            if(Objects.nonNull(categoria.getId())) {
                persistedCategorias.add(this.categoriaService.findById(categoria.getId()));
            } else {
                persistedCategorias.add(this.categoriaService.save(categoria));
            }
        }

        livro.setCategorias(persistedCategorias);
    }

}
