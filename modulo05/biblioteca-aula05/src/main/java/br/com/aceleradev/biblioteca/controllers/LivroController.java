package br.com.aceleradev.biblioteca.controllers;


import br.com.aceleradev.biblioteca.models.Livro;
import br.com.aceleradev.biblioteca.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    //INJECAO DE DEPENDENCIA
    private final LivroService livroService;

    @Autowired
    public LivroController(LivroService livroService){
        this.livroService = livroService;
    }

    @PostMapping
    public Livro save(@RequestBody Livro livro){
        return this.livroService.save(livro);
    }

    @GetMapping
    public List<Livro> findAll(){
        return this.livroService.findAll();
    }

    @GetMapping("/{id}/titulo/{titulo}")
    public Livro findById(@PathVariable Long id, @PathVariable String titulo){
        return this.livroService.findById(id);
    }

}
