package br.com.codenation.biblioteca.services;


import br.com.codenation.biblioteca.models.Leitor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface LeitorService {

    Leitor save(Leitor leitor);

    Page<Leitor> findAll(Pageable pageable);

    Leitor findById(Long id);

    void update(Long id, Leitor leitor);

    void delete(Long id);
}
