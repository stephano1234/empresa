package br.com.contmatic.model.endereco;

import static br.com.contmatic.utilidades.ConstantesString.NOME;

import static br.com.contmatic.utilidades.MensagensErro.NOME_INVALIDO;
import static br.com.contmatic.utilidades.MensagensErro.VALOR_NULO;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * The Class Cidade.
 */
public class Cidade {

    /** The nome. */
    @NotNull(message = VALOR_NULO)
    @Pattern(regexp = NOME, message = NOME_INVALIDO)
    private String nome;
    
    /** The tipo uf. */
    @NotNull(message = VALOR_NULO)
    private TipoUf tipoUf;
    
    /**
     * Instantiates a new cidade.
     *
     * @param nome the nome
     * @param tipoUf the tipo uf
     */
    public Cidade(String nome, TipoUf tipoUf) {
        this.nome = nome;
        this.tipoUf = tipoUf;
    }

    /**
     * Gets the nome.
     *
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Sets the nome.
     *
     * @param nome the new nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Gets the tipo uf.
     *
     * @return the tipo uf
     */
    public TipoUf getTipoUf() {
        return tipoUf;
    }

    /**
     * Sets the tipo uf.
     *
     * @param tipoUf the new tipo uf
     */
    public void setTipoUf(TipoUf tipoUf) {
        this.tipoUf = tipoUf;
    }
    
    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public final int hashCode() {
        return new HashCodeBuilder()
                .append(nome)
                .append(tipoUf)
                .toHashCode();
    }
    
    /**
     * Equals.
     *
     * @param objeto the objeto
     * @return true, if successful
     */
    @Override
    public final boolean equals(Object objeto) {
        if (!(objeto instanceof Cidade)) {
            return false;
        }
        if (this == objeto) {
            return true;
        }
        final Cidade outroCidade = (Cidade) objeto;
        return new EqualsBuilder()
                .append(nome, outroCidade.nome)
                .append(tipoUf, outroCidade.tipoUf)
                .isEquals();
    }
    
    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this, JSON_STYLE)
                .append("nome", nome)
                .append("tipoUf", tipoUf)
                .toString();
    }
    
}
