package br.com.aceleradev.reflection.credito;

import br.com.aceleradev.reflection.enums.RegraValor;

public class RegraCredito {

    private String nome;
    private String referencia;
    private long valorReferencia;
    private RegraValor regra;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public long getValorReferencia() {
        return valorReferencia;
    }

    public void setValorReferencia(long valorReferencia) {
        this.valorReferencia = valorReferencia;
    }

    public RegraValor getRegra() {
        return regra;
    }

    public void setRegra(RegraValor regra) {
        this.regra = regra;
    }

    public boolean valida(long valor) {
        if(isRegraValorMax()) return valor <= this.valorReferencia;

        return valor >= this.valorReferencia;
    }

    private boolean isRegraValorMax() {
        return this.regra.equals(RegraValor.MAX);
    }
}
