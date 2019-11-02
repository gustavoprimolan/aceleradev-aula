package br.com.aceleradev.domain;

import br.com.aceleradev.exceptions.NumeroMaximoDeAlunosException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Entity
public class Disciplina {

    @Id
    private Long id;

    private String nome;

    @ManyToMany
    @JoinTable(name="disciplina_aluno",
            joinColumns = {@JoinColumn(name="id_disciplina")},
            inverseJoinColumns = {@JoinColumn(name="id_aluno")})
    private List<Aluno> alunos = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_professor")
    private Professor professor;

    private String descricao;

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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
