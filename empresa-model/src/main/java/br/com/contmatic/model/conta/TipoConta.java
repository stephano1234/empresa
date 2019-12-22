package br.com.contmatic.model.conta;

/**
 * The Enum TipoConta.
 */
public enum TipoConta {

    /** The conta corrente. */
    CONTA_CORRENTE("Conta corrente"),
    
    /** The conta poupanca. */
    CONTA_POUPANCA("Conta poupança");
    
    /** The descricao. */
    private String descricao;
    
    /**
     * Instantiates a new tipo conta.
     *
     * @param descricao the descricao
     */
    private TipoConta(String descricao) {
        this.descricao = descricao;
    }
    
    /**
     * Gets the descricao.
     *
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }
    
}
