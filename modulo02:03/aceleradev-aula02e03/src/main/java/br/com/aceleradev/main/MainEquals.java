package br.com.aceleradev.main;

import br.com.aceleradev.domain.PessoaEqualsAndHash;

import java.util.HashSet;

public class MainEquals {

    public static void main(String[] args) {

        HashSet<PessoaEqualsAndHash> pessoas = new HashSet<>();

//        List<Pessoa> pessoas = new ArrayList<>();

        PessoaEqualsAndHash pessoa1 = new PessoaEqualsAndHash(1l, "Joao", "Da Silva");
        PessoaEqualsAndHash pessoa2 = new PessoaEqualsAndHash(2l, "Pedro", "A2");
        PessoaEqualsAndHash pessoa3 = new PessoaEqualsAndHash(3l, "Henrique", "Sobrenome");

        pessoas.add(pessoa1);
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        pessoas.add(pessoa3);

        System.out.println(pessoas.size());

        PessoaEqualsAndHash pessoaProcurar = new PessoaEqualsAndHash(1l, "Pedro", "Sobrenome");

//        System.out.println(pessoas.contains(pessoaProcurar));

        System.out.println(pessoa1.equals(pessoaProcurar));
        System.out.println(pessoa1.hashCode());
        System.out.println(pessoaProcurar.hashCode());
//        System.out.println(pessoa1.hashCode() == pessoaProcurar.hashCode());


    }


}
