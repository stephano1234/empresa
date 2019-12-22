package br.com.contmatic.model.contato;

import static br.com.contmatic.utilidades.ConstantesString.CELULAR;
import static br.com.contmatic.utilidades.ConstantesString.DDD;

import static br.com.contmatic.utilidades.MensagensErro.CELULAR_INVALIDO;
import static br.com.contmatic.utilidades.MensagensErro.DDD_INVALIDO;
import static br.com.contmatic.utilidades.MensagensErro.VALOR_NULO;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * The Class Celular.
 */
public class Celular {

    /** The ddd. */
    @NotNull(message = VALOR_NULO)   
    @Pattern(regexp = DDD, message = DDD_INVALIDO)
    private String ddd;
    
    /** The numero. */
    @NotNull(message = VALOR_NULO)
    @Pattern(regexp = CELULAR, message = CELULAR_INVALIDO)
    private String numero;
    
    /** The tipo contato celular. */
    @NotNull(message = VALOR_NULO)
    private TipoContatoCelular tipoContatoCelular;
    
    /**
     * Instantiates a new celular.
     *
     * @param ddd the ddd
     * @param numero the numero
     * @param tipoContatoCelular the tipo contato celular
     */
    public Celular(String ddd, String numero, TipoContatoCelular tipoContatoCelular) {
        this.ddd = ddd;
        this.numero = numero;
        this.tipoContatoCelular = tipoContatoCelular;
    }

    /**
     * Gets the ddd.
     *
     * @return the ddd
     */
    public String getDdd() {
        return ddd;
    }

    /**
     * Sets the ddd.
     *
     * @param ddd the new ddd
     */
    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    /**
     * Gets the numero.
     *
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * Sets the numero.
     *
     * @param numero the new numero
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * Gets the tipo contato celular.
     *
     * @return the tipo contato celular
     */
    public TipoContatoCelular getTipoContatoCelular() {
        return tipoContatoCelular;
    }

    /**
     * Sets the tipo contato celular.
     *
     * @param tipoContatoCelular the new tipo contato celular
     */
    public void setTipoContatoCelular(TipoContatoCelular tipoContatoCelular) {
        this.tipoContatoCelular = tipoContatoCelular;
    }
    
    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public final int hashCode() {
        return new HashCodeBuilder()
                .append(ddd)
                .append(numero)
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
        if (!(objeto instanceof Celular)) {
            return false;
        }
        if (this == objeto) {
            return true;
        }
        final Celular outroCelular = (Celular) objeto;
        return new EqualsBuilder()
                .append(ddd, outroCelular.ddd)
                .append(numero, outroCelular.numero)
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
                .append("ddd", ddd)
                .append("numero", numero)
                .append("tipoContatoCelular", tipoContatoCelular)
                .toString();
    }
    
}
