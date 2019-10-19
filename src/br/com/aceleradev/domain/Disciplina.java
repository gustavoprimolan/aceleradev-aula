package br.com.aceleradev.domain;

import br.com.aceleradev.exceptions.NumeroMaximoDeAlunosException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Disciplina {

    private String nome;

    private List<Aluno> alunos = new ArrayList<>();

    private Professor professor;

    public Disciplina(String nome, Professor professor) {
        this.nome = nome;
        this.professor = professor;
    }

    public void matricular(Aluno aluno) {
        if(alunos.size() == 10){
            throw new NumeroMaximoDeAlunosException("Disciplina lotada");
        }
        alunos.add(aluno);
    }

    public void mostraAlunos() {
        alunos.forEach(System.out::println);

//        alunos.forEach(aluno -> {
//            System.out.println(aluno);
//        });
//
//        alunos.forEach(aluno -> System.out.println(aluno));
//
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "nome='" + nome + '\'' +
                ", alunos=" + alunos +
                ", professor=" + professor +
                "\n";
    }
}
