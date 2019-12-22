package br.com.contmatic.model.pessoa;

/**
 * The Enum TipoEstadoCivil.
 */
public enum TipoEstadoCivil {

    /** The solteiro. */
    SOLTEIRO("Solteiro(a)"),
    
    /** The casado. */
    CASADO("Casado(a)"),
    
    /** The divorciado. */
    DIVORCIADO("Divorciado(a)"),
    
    /** The viuvo. */
    VIUVO("Viuvo(a)"),
    
    /** The outros. */
    OUTROS("Outros");
    
    /** The descricao. */
    private String descricao;
    
    /**
     * Instantiates a new tipo estado civil.
     *
     * @param descricao the descricao
     */
    private TipoEstadoCivil(String descricao) {
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
