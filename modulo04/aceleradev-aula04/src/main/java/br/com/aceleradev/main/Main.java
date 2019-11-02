package br.com.aceleradev.main;

import br.com.aceleradev.domain.Aluno;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("curso");
        factory.close();
    }

}
