package br.com.contmatic.model.pessoa;

/**
 * The Enum TipoGrauInstrucao.
 */
public enum TipoGrauInstrucao {

    /** The analfabeto. */
    ANALFABETO("Analfabeto"),
    
    /** The ate 5 ano incompleto ensino fundamental. */
    ATE_5_ANO_INCOMPLETO_ENSINO_FUNDAMENTAL("Até o 5º ano incompleto do Ensino Fundamental"),
    
    /** The o 5 ano completo ensino fundamental. */
    O_5_ANO_COMPLETO_ENSINO_FUNDAMENTAL("5º ano completo do Ensino Fundamental"),
    
    /** The do 6 ao 9 ano ensino fundamental incompleto. */
    DO_6_AO_9_ANO_ENSINO_FUNDAMENTAL_INCOMPLETO("Do 6º ao 9º ano do Ensino Fundamental incompleto"),
    
    /** The ensino fundamental completo. */
    ENSINO_FUNDAMENTAL_COMPLETO("Ensino Fundamental completo"),
    
    /** The ensino medio incompleto. */
    ENSINO_MEDIO_INCOMPLETO("Ensino Médio incompleto"),
    
    /** The ensino medio completo. */
    ENSINO_MEDIO_COMPLETO("Ensino Médio completo"),
    
    /** The superior incompleto. */
    SUPERIOR_INCOMPLETO("Superior incompleto"),
    
    /** The superior completo. */
    SUPERIOR_COMPLETO("Superior completo"),
    
    /** The pos graduacao especializacao. */
    POS_GRADUACAO_ESPECIALIZACAO("Pós-Graduação / Especialização"),
    
    /** The mestrado. */
    MESTRADO("Mestrado"),
    
    /** The doutorado. */
    DOUTORADO("Doutorado"),
    
    /** The pos doutorado. */
    POS_DOUTORADO("Pós-Doutorado");
    
    /** The descricao. */
    private String descricao;
    
    /**
     * Instantiates a new tipo grau instrucao.
     *
     * @param descricao the descricao
     */
    private TipoGrauInstrucao(String descricao) {
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
