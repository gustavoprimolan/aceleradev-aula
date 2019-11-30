package br.com.codenation.biblioteca.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = Leitor.TABLE_NAME)
public class Leitor {

    public static final String TABLE_NAME = "leitor";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "id.leitor")
    private List<Avaliacao> avaliacoes;

    public void setIdAsNull() {
        this.id = null;
    }

    public void replace(Leitor leitor) {
        this.nome = leitor.getNome();
    }
}
