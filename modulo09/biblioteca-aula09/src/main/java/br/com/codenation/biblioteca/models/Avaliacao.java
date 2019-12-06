package br.com.codenation.biblioteca.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = Avaliacao.TABLE_NAME)
public class Avaliacao {

    public static final String TABLE_NAME = "avaliacao";

    @EmbeddedId
    private AvaliacaoIdentity id;

    @Max(5)
    @Min(1)
    @NotNull
    private Byte nota;

    @NotBlank
    @NotNull
    private String descricao;

}
