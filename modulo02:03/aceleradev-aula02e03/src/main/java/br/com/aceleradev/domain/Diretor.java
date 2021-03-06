package br.com.aceleradev.domain;

import java.util.Arrays;
import java.util.List;

public class Diretor extends UsuarioAutorizavel{

    public Diretor(String nome, String login, String cpf) {
        super(nome, login, cpf);
    }

    @Override
    protected List<String> getAutorizacao() {
        return Arrays.asList("ADMIN");
    }

    @Override
    protected boolean verificarAutorizacaoLogin() {
        return false;
    }
}
