package br.com.codenation.biblioteca.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.List;

import static org.springframework.util.CollectionUtils.isEmpty;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = Livro.TABLE_NAME)
public class Livro {

    public static final String TABLE_NAME = "livro";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Título não pode ser nulo")
    @Length(min = 5, max = 20, message = "Titulo nao pode ser menor que 5 caracteres ou miaor que 20")
    private String titulo;

    @Min(message = "A quantidade mínima é 0", value = 0)
    @Max(message = "A quantidade máxima é 10", value = 10)
    @PositiveOrZero(message = "A quantidade de estoque deve ser maior que zero")
    @Column(name = "quantidade_estoque")
    private Long quantidadeEstoque;

    @JsonIgnore
    @OneToMany(mappedBy = "id.livro")
    private List<Avaliacao> avaliacoes;

    @ManyToMany
    @JoinTable(name="livro_categoria",
            joinColumns = @JoinColumn(name="id_livro"),
            inverseJoinColumns = @JoinColumn(name="id_categoria"))
    private List<Categoria> categorias;

    @JsonIgnore
    public boolean isCategoriasEmpty() {
        return isEmpty(this.categorias);
    }

    public void setIdAsNull() {
        this.id = null;
    }

    public void replace(Livro livro) {
        this.titulo = livro.getTitulo();
        this.quantidadeEstoque = livro.getQuantidadeEstoque();
        this.categorias = livro.getCategorias();
    }
}
