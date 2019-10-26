package br.com.aceleradev.domain.interfaces;

public interface UsuarioAutorizavel {

    default boolean temAutorizacao() {
        return true;
    }

}
