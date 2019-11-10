package br.com.aceleradev.biblioteca.repositories;


import br.com.aceleradev.biblioteca.models.Categoria;
import br.com.aceleradev.biblioteca.models.Livro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


//CrudRepository
//PagingAndSortingRepository
//JpaRepository
@Repository
public interface LivroRepository extends CrudRepository<Livro, Long> {

    List<Livro> findAll();

    List<Livro> findByTitulo(String titulo);

    @Query("FROM Livro l WHERE l.categorias LIKE :categoria")
    List<Livro> findComCategoria(@Param("categoria") Categoria categoria);

}
