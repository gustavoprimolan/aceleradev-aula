package br.com.aceleradev.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "coordenador")
public class Coordenador extends UsuarioAutorizavel {

    private long matricula;

    public Coordenador(String nome, String login, String cpf) {
        super(nome, login, cpf);
    }

    @Override
    protected List<String> getAutorizacao() {
        return Arrays.asList("COORD");
    }

    @Override
    protected boolean verificarAutorizacaoLogin() {
        return true;
    }

    public long getMatricula() {
        return matricula;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }

}
