package br.com.codenation.biblioteca.repositories;

import br.com.codenation.biblioteca.models.Leitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeitorRepository extends JpaRepository<Leitor, Long> {
}
