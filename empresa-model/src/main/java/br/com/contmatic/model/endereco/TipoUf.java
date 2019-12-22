package br.com.contmatic.model.endereco;

/**
 * The Enum TipoUf.
 */
public enum TipoUf {

    /** The ac. */
    AC("AC"),
    
    /** The al. */
    AL("AL"),
    
    /** The ap. */
    AP("AP"),
    
    /** The am. */
    AM("AM"),
    
    /** The ba. */
    BA("BA"),
    
    /** The ce. */
    CE("CE"),
    
    /** The df. */
    DF("DF"),
    
    /** The es. */
    ES("ES"),
    
    /** The go. */
    GO("GO"),
    
    /** The ma. */
    MA("MA"),
    
    /** The mt. */
    MT("MT"),
    
    /** The ms. */
    MS("MS"),
    
    /** The mg. */
    MG("MG"),
    
    /** The pa. */
    PA("PA"),
    
    /** The pb. */
    PB("PB"),
    
    /** The pr. */
    PR("PR"),
    
    /** The pe. */
    PE("PE"),
    
    /** The pi. */
    PI("PI"),
    
    /** The rj. */
    RJ("RJ"),
    
    /** The rn. */
    RN("RN"),
    
    /** The rs. */
    RS("RS"),
    
    /** The ro. */
    RO("RO"),
    
    /** The rr. */
    RR("RR"),
    
    /** The sc. */
    SC("SC"),
    
    /** The sp. */
    SP("SP"),
    
    /** The se. */
    SE("SE"),
    
    /** The to. */
    TO("TO");

    /** The sigla. */
    private String sigla;
    
    /**
     * Instantiates a new tipo uf.
     *
     * @param sigla the sigla
     */
    private TipoUf(String sigla) {
        this.sigla = sigla;
    }
    
    /**
     * Gets the sigla.
     *
     * @return the sigla
     */
    public String getSigla() {
        return sigla;
    }
}
