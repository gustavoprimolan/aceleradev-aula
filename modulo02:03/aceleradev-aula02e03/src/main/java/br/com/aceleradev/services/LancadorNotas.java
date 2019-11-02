package br.com.aceleradev.services;

import br.com.aceleradev.domain.UsuarioAutorizavel;
import br.com.aceleradev.exceptions.UsuarioNaoPossuiAutorizacao;

public class LancadorNotas {

    public void login(UsuarioAutorizavel usuarioAutorizavel) {
        if(!usuarioAutorizavel.temAutorizacao())
            throw new UsuarioNaoPossuiAutorizacao("Usuario nao possui autorizaca");

        System.out.println("Notas lancadas");
    }


}
