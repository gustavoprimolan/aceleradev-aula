package br.com.aceleradev.domain;

import br.com.aceleradev.annotations.Coluna;
import br.com.aceleradev.exceptions.LoginInvalidoException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import static br.com.aceleradev.utils.MensagensParaExcecoes.LOGIN_MENOR_DE_TRES_CARACTERES;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false, length = 14, unique = true)
    private String cpf;

    public Usuario(){

    }

    public Usuario(String nome, String login, String cpf) {
        this.nome = nome;
        setLogin(login);
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Coluna(posicao = 1, titulo = "NOME")
    public String getNome() {
        return nome;
    }

    @Coluna(posicao = 2, titulo = "CPF")
    public String getCpf() {
        return cpf;
    }

    @Coluna(posicao = 3, titulo = "LOGIN")
    public String getLogin() {
        return login;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLogin(String login) {
        if(loginInvalido(login)){
            throw new LoginInvalidoException(LOGIN_MENOR_DE_TRES_CARACTERES);
        }

        this.login = login;

    }

    private boolean loginInvalido(String login) {
        return login.length() <= 3;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "nome: " + this.nome
                + "\nlogin: " + this.login
                + "\ncpf: " + this.cpf + "\n";
    }

}
