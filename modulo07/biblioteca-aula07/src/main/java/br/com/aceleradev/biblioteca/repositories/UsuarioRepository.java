package br.com.aceleradev.biblioteca.repositories;

import br.com.aceleradev.biblioteca.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

//CrudRepository
//PagingAndSortingRepository
//JpaRepository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUsername(String username);

}
