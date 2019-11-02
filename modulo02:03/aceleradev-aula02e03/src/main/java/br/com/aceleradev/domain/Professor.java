package br.com.aceleradev.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Arrays;
import java.util.List;

@Entity
public class Professor extends UsuarioAutorizavel {

    @OneToMany(mappedBy = "professor")
    private List<Disciplina> disciplinas;

    public Professor(String nome, String login, String cpf) {
        super(nome, login, cpf);
    }

    @Override
    protected List<String> getAutorizacao() {
        return Arrays.asList("PROF");
    }

    @Override
    protected boolean verificarAutorizacaoLogin() {
        return true;
    }

}
