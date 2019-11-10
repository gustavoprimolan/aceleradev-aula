package br.com.aceleradev.biblioteca.models;


import ch.qos.logback.classic.db.names.TableName;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = Avaliacao.TABLE_NAME)
public class Avaliacao {

    public static final String TABLE_NAME = "avaliacao";

    @EmbeddedId
    private AvaliacaoIdentity avaliacaoIdentity;

    @Max(5)
    @Min(1)
    @NotNull
    private Byte nota;

    @NotBlank
    @NotNull
    private String descricao;

    public AvaliacaoIdentity getAvaliacaoIdentity() {
        return avaliacaoIdentity;
    }

    public void setAvaliacaoIdentity(AvaliacaoIdentity avaliacaoIdentity) {
        this.avaliacaoIdentity = avaliacaoIdentity;
    }

    public Byte getNota() {
        return nota;
    }

    public void setNota(Byte nota) {
        this.nota = nota;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
