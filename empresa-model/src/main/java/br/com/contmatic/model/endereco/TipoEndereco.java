package br.com.contmatic.model.endereco;

/**
 * The Enum TipoEndereco.
 */
public enum TipoEndereco {
    
    /** The residencial. */
    RESIDENCIAL("Endereço residencial"),
    
    /** The comercial. */
    COMERCIAL("Endereço comercial");
    
    /** The descricao. */
    private String descricao;
    
    /**
     * Instantiates a new tipo endereco.
     *
     * @param descricao the descricao
     */
    private TipoEndereco(String descricao) {
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
