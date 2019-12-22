package br.com.contmatic.model.conta;

import static br.com.contmatic.utilidades.ConstantesString.NUMERO_CONTA;

import static br.com.contmatic.utilidades.MensagensErro.NUMERO_CONTA_INVALIDO;
import static br.com.contmatic.utilidades.MensagensErro.VALOR_NULO;

import static org.apache.commons.lang3.builder.ToStringStyle.JSON_STYLE;

import javax.validation.Valid;
import javax.validation.constraints.*;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * The Class Conta.
 */
public class Conta {

    /** The numero. */
    @NotNull(message = VALOR_NULO)
    @Pattern(regexp = NUMERO_CONTA, message = NUMERO_CONTA_INVALIDO)
    private String numero;
    
    /** The agencia. */
    @NotNull(message = VALOR_NULO)
    @Valid
    private Agencia agencia;
    
    /** The tipo conta. */
    @NotNull(message = VALOR_NULO)
    private TipoConta tipoConta;

    /**
     * Instantiates a new conta.
     *
     * @param numero the numero
     * @param agencia the agencia
     * @param tipoConta the tipo conta
     */
    public Conta(String numero, Agencia agencia, TipoConta tipoConta) {
        this.numero = numero;
        this.agencia = agencia;
        this.tipoConta = tipoConta;
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
     * Gets the agencia.
     *
     * @return the agencia
     */
    public Agencia getAgencia() {
        return agencia;
    }

    /**
     * Sets the agencia.
     *
     * @param agencia the new agencia
     */
    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    /**
     * Gets the tipo conta.
     *
     * @return the tipo conta
     */
    public TipoConta getTipoConta() {
        return tipoConta;
    }

    /**
     * Sets the tipo conta.
     *
     * @param tipoConta the new tipo conta
     */
    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }
    
    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public final int hashCode() {
        return new HashCodeBuilder()
                .append(numero)
                .append(agencia)
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
        if (!(objeto instanceof Conta)) {
            return false;
        }
        if (this == objeto) {
            return true;
        }
        final Conta outroConta = (Conta) objeto;
        return new EqualsBuilder()
                .append(numero, outroConta.numero)
                .append(agencia, outroConta.agencia)
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
                .append("numero", numero)
                .append("agencia", agencia)
                .append("tipoConta", tipoConta)
                .toString();
    }
    
}
