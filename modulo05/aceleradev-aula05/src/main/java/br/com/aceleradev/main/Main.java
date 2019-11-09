package br.com.aceleradev.main;

import br.com.aceleradev.dao.AlunoDAO;
import br.com.aceleradev.domain.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("curso02");

        EntityManager manager = factory.createEntityManager();

        AlunoDAO alunoDAO = new AlunoDAO(manager);
        alunoDAO.save(new Aluno("José", "jose01", "123.432.123-42"));
        alunoDAO.save(new Aluno("Pedro", "pedro01", "213.442.123-42"));

        Aluno aluno = new Aluno("Joaquim", "joaquim", "213.431.123-42");

        alunoDAO.save(aluno);
        alunoDAO.findAll().forEach(System.out::println);

        alunoDAO.delete(aluno);

        alunoDAO.findAll().forEach(System.out::println);

        factory.close();
    }

}
