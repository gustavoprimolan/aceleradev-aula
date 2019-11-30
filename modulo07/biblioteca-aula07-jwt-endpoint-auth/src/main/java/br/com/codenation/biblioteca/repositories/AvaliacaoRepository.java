package br.com.codenation.biblioteca.repositories;

import br.com.codenation.biblioteca.models.Avaliacao;
import br.com.codenation.biblioteca.models.AvaliacaoIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, AvaliacaoIdentity> {
}
