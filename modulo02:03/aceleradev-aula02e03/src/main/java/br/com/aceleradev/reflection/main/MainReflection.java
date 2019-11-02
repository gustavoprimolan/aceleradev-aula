package br.com.aceleradev.reflection.main;

import br.com.aceleradev.reflection.credito.AnalisadorCredito;
import br.com.aceleradev.reflection.externo.Pessoa;

public class MainReflection {

    public static void main(String[] args) {
        Pessoa pessoa = getPessoa();

        AnalisadorCredito analisador = new AnalisadorCredito();

        boolean resultado = analisador.analisarCredito(pessoa);

        if(resultado) System.out.println("Credito Aprovado");
        else System.out.println("Credito Reprovado");

    }

    private static Pessoa getPessoa() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Joao");
        pessoa.setCpf("123.456.789-21");
        pessoa.setQuantidadeChequesDevolvidos(0);
        pessoa.setScoreSCPC(500);
        pessoa.setScoreSerasa(500);
        pessoa.setValorDivida(1000);
        return pessoa;
    }

}
