package br.com.aceleradev.domain;

import java.util.List;

public abstract class UsuarioAutorizavel extends Usuario {

    public UsuarioAutorizavel(String nome, String login, String cpf) {
        super(nome, login, cpf);
    }

    //DESIGN PATTERN - TEMPLATE METHOD
    //HOOK METHOD
    public boolean temAutorizacao() {
        List<String> autorizacoes = getAutorizacao();
        return autorizacoes.contains("ADMIN") || verificarAutorizacaoLogin();
    }

    protected abstract List<String> getAutorizacao();

    protected abstract boolean verificarAutorizacaoLogin();

}
