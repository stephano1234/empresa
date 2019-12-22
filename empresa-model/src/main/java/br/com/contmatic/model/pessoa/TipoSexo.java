package br.com.contmatic.model.pessoa;

/**
 * The Enum TipoSexo.
 */
public enum TipoSexo {

    /** The masculino. */
    MASCULINO("Masculino"),
    
    /** The feminino. */
    FEMININO("Feminino");
    
    /** The descricao. */
    private String descricao;
    
    /**
     * Instantiates a new tipo sexo.
     *
     * @param descricao the descricao
     */
    private TipoSexo(String descricao) {
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
