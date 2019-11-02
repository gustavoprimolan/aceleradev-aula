package br.com.aceleradev.exceptions;

public class UsuarioNaoPossuiAutorizacao extends RuntimeException {
    public UsuarioNaoPossuiAutorizacao(String message) {
        super(message);
    }
}
