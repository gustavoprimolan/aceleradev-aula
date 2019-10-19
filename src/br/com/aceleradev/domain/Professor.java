package br.com.aceleradev.domain;

import java.time.LocalDate;

public class Professor extends Usuario {
    private int anoInicioCarreira; 

    public Professor(String nome, String login, String cpf, int anoInicio) {
        super(nome, login, cpf);

        this.anoInicioCarreira = anoInicio;        
    }



}
