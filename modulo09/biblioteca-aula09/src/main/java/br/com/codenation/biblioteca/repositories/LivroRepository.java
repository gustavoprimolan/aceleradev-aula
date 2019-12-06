package br.com.codenation.biblioteca.repositories;

import br.com.codenation.biblioteca.models.Categoria;
import br.com.codenation.biblioteca.models.Livro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//CrudRepository
//JpaRepository
//PagingAndSortingRepository
@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

}
