package br.com.aceleradev.biblioteca.models;


import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AvaliacaoIdentity implements Serializable {

    @ManyToOne
    @NotNull
    private Leitor leitor;

    @ManyToOne
    @NotNull
    private Livro livro;

    public Leitor getLeitor() {
        return leitor;
    }

    public void setLeitor(Leitor leitor) {
        this.leitor = leitor;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AvaliacaoIdentity)) return false;
        AvaliacaoIdentity that = (AvaliacaoIdentity) o;
        return Objects.equals(getLeitor(), that.getLeitor()) &&
                Objects.equals(getLivro(), that.getLivro());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLeitor(), getLivro());
    }

}
