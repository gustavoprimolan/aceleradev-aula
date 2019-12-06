package br.com.codenation.biblioteca.controllers;

import br.com.codenation.biblioteca.models.Livro;
import br.com.codenation.biblioteca.services.LivroService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    @Autowired
    public LivroController(LivroService livroService){
        this.livroService = livroService;
    }

    @GetMapping
    @ApiOperation(value = "Retorna livros paginados", response = Livro[].class)
    public ResponseEntity<Page<Livro>> findAll(@PageableDefault(sort = "id", direction = Sort.Direction.DESC, page = 0, size = 24) Pageable pageable){
        return ResponseEntity.ok(this.livroService.findAll(pageable));
    }

    @GetMapping("/{id}")
//    public ResponseEntity<Livro> findById(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails){
    public ResponseEntity<Livro> findById(@PathVariable Long id, Authentication authentication){
//        System.out.println(userDetails);
        System.out.println(authentication);
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
    public ResponseEntity<Void> update(@PathVariable Long id, @Valid @RequestBody Livro livro){
        this.livroService.update(id, livro);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.livroService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
