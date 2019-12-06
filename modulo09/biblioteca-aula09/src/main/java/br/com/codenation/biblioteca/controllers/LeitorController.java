package br.com.codenation.biblioteca.controllers;

import br.com.codenation.biblioteca.models.Leitor;
import br.com.codenation.biblioteca.services.LeitorService;
import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/leitores")
public class LeitorController {

    private final LeitorService leitorService;

    @Autowired
    public LeitorController(LeitorService leitorService){
        this.leitorService = leitorService;
    }

    @GetMapping
    public ResponseEntity<Page<Leitor>> findAll(@PageableDefault(sort = "id", direction = Sort.Direction.DESC, page = 0, size = 24) Pageable pageable){
        return ResponseEntity.ok(this.leitorService.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Leitor> findById(@PathVariable Long id){
        return ResponseEntity.ok(this.leitorService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Leitor> save(@Valid @RequestBody Leitor leitor){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.leitorService.save(leitor));
    }

//    @PostMapping
//    public ResponseEntity<Void> save(@Valid @RequestBody Leitor leitor){
//        Leitor leitorSalvo = this.leitorService.save(leitor);
//        URI uri = ServletUriComponentsBuilder
//                .fromCurrentRequest()
//                .path("/{id}")
//                .buildAndExpand(leitorSalvo.getId())
//                .toUri();
//        return ResponseEntity.created(uri).build();
//    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @Valid @RequestBody Leitor leitor){
        this.leitorService.update(id, leitor);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.leitorService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
