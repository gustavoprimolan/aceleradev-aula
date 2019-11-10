package br.com.aceleradev.dao;

import br.com.aceleradev.domain.Aluno;
import br.com.aceleradev.domain.Disciplina;
import br.com.aceleradev.domain.Professor;

import javax.persistence.EntityManager;
import java.util.List;

public class DisciplinaDAO {

    private EntityManager manager;

    public DisciplinaDAO(EntityManager manager){
        this.manager = manager;
    }

    public void save(Disciplina disciplina){
        manager.getTransaction().begin();
        manager.persist(disciplina);
        manager.getTransaction().commit();
    }

    public List<Disciplina> findAll() {
        //HQL - Hibernate Query Language - Hibernate
        //JPQL - Java Persistence Query Language - JPA
        return manager.createQuery("FROM Disciplina").getResultList();
    }


    public void delete(Disciplina disciplina) {
        manager.getTransaction().begin();
        manager.remove(disciplina);
        manager.getTransaction().commit();
    }

}
