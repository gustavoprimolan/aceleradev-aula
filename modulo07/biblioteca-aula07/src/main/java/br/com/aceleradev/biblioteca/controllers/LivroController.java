package br.com.aceleradev.biblioteca.controllers;


import br.com.aceleradev.biblioteca.models.Livro;
import br.com.aceleradev.biblioteca.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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

    @GetMapping
    public ResponseEntity<Page<Livro>> findAll(@PageableDefault(sort = "id", direction = Sort.Direction.DESC, page = 0, size = 24) Pageable pageable){
        return ResponseEntity.ok(this.livroService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Long id){
        return ResponseEntity.ok(this.livroService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Livro> save(@Valid @RequestBody Livro livro){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.livroService.save(livro));
    }

//    @PostMapping
//    public ResponseEntity<Void> save(@Valid @RequestBody Livro livro){
//        Livro livroSalvo = this.livroService.save(livro);
//        URI uri = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(livroSalvo.getId())
//                .toUri();
//        return ResponseEntity.created(uri).build();
//    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,
                                       @Valid @RequestBody Livro livro){
        this.livroService.update(id, livro);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.livroService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
