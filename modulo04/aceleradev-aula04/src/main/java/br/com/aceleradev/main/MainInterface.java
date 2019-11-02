package br.com.aceleradev.main;

import br.com.aceleradev.domain.Coordenador;
import br.com.aceleradev.domain.Professor;
import br.com.aceleradev.services.LancadorNotas;

public class MainInterface {

    public static void main(String[] args) {

        Coordenador coordenador =
                new Coordenador("Coordenador01", "loginCoord","123.567.899-32");

        Professor professor =
                new Professor("Professor01", "loginProof","543.567.899-32");

        LancadorNotas lancadorNotas = new LancadorNotas();
        lancadorNotas.login(coordenador);
        lancadorNotas.login(professor);


    }

}
