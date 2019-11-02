package br.com.aceleradev.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Aluno extends Usuario{

    private Integer numeroMatricula;

    @ManyToMany
    @JoinTable(name="disciplina_aluno",
            joinColumns = {@JoinColumn(name="id_aluno")},
            inverseJoinColumns = {@JoinColumn(name="id_disciplina")})
    private List<Disciplina> disciplinas;

    public Aluno(String nome, String login, String cpf) {
        super(nome, login, cpf);
    }

    public Integer getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(Integer numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

}
