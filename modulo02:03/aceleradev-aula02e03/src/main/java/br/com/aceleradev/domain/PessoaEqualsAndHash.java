package br.com.aceleradev.domain;

import java.util.Objects;

public class PessoaEqualsAndHash {

    private long id;
    private String nome;
    private String sobrenome;
    private double altura;

    public PessoaEqualsAndHash(long id, String nome, String sobrenome) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PessoaEqualsAndHash)) return false;
        PessoaEqualsAndHash pessoa = (PessoaEqualsAndHash) o;
        return getId() == pessoa.getId() &&
                getSobrenome().equals(pessoa.getSobrenome());
    }


    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNome());
    }

}
