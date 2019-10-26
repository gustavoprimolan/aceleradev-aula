package br.com.aceleradev.reflection.externo;

public class Pessoa {

    private String cpf;
    private String nome;
    private long scoreSerasa;
    private long scoreSCPC;
    private long quantidadeChequesDevolvidos;
    private long valorDivida;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getScoreSerasa() {
        return scoreSerasa;
    }

    public void setScoreSerasa(long scoreSerasa) {
        this.scoreSerasa = scoreSerasa;
    }

    public long getScoreSCPC() {
        return scoreSCPC;
    }

    public void setScoreSCPC(long scoreSCPC) {
        this.scoreSCPC = scoreSCPC;
    }

    public long getQuantidadeChequesDevolvidos() {
        return quantidadeChequesDevolvidos;
    }

    public void setQuantidadeChequesDevolvidos(long quantidadeChequesDevolvidos) {
        this.quantidadeChequesDevolvidos = quantidadeChequesDevolvidos;
    }

    public long getValorDivida() {
        return valorDivida;
    }

    public void setValorDivida(long valorDivida) {
        this.valorDivida = valorDivida;
    }
}
