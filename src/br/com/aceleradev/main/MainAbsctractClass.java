package br.com.aceleradev.main;

import br.com.aceleradev.domain.Coordenador;
import br.com.aceleradev.domain.Diretor;
import br.com.aceleradev.domain.Professor;
import br.com.aceleradev.services.LancadorNotas;

public class MainAbsctractClass {

    public static void main(String[] args) {
        Professor professor =
                new Professor("Nome Professor", "login", "123.456.678-21");

        Coordenador coordenador =
                new Coordenador("Nome Coordenador", "login", "123.456.678-21");

        Diretor diretor =
                new Diretor("Nome Diretor", "login", "123.456.678-21");

        new LancadorNotas().login(diretor);

    }

}
