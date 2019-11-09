package br.com.aceleradev.main;

import br.com.aceleradev.domain.Aluno;
import br.com.aceleradev.domain.Professor;
import br.com.aceleradev.domain.Usuario;
import br.com.aceleradev.services.GeradorDeRelatorio;

import java.util.ArrayList;
import java.util.List;

public class MainAnnotation {

    public static void main(String[] args) {
        GeradorDeRelatorio gerador = new GeradorDeRelatorio();
        Usuario usuario =
                new Aluno("Joaquim", "joaquim123", "123.456.789-21");

        Usuario usuario2 =
                new Professor("Pedro", "pedro123", "123.456.789-21");

        List<Object> usuarios = new ArrayList<>();
        usuarios.add(usuario);
        usuarios.add(usuario2);

        gerador.gerarRelatorio(usuarios, 3);

    }

}
