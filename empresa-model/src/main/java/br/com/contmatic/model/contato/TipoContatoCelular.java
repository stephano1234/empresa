package br.com.contmatic.model.contato;

/**
 * The Enum TipoContatoCelular.
 */
public enum TipoContatoCelular {

    /** The apenas ligacao. */
    APENAS_LIGACAO("Recebe apenas ligações"),
    
    /** The apenas mensagem texto. */
    APENAS_MENSAGEM_TEXTO("Recebe apenas mensagens de texto"),
    
    /** The apenas mensagem internet. */
    APENAS_MENSAGEM_INTERNET("Recebe apenas mensagens de internet"),
    
    /** The ligacao mensagem texto. */
    LIGACAO_MENSAGEM_TEXTO("Recebe apenas ligações e mensagens de texto"),
    
    /** The ligacao mensagem internet. */
    LIGACAO_MENSAGEM_INTERNET("Recebe apenas ligações e mensagens de internet"),
    
    /** The mensagem texto internet. */
    MENSAGEM_TEXTO_INTERNET("Recebe apenas mensagens de texto e de internet"),
    
    /** The ligacao mensagem texto internet. */
    LIGACAO_MENSAGEM_TEXTO_INTERNET("Recebe ligações, mensagens de texto e de internet");
    
    /** The descricao. */
    private String descricao;
    
    /**
     * Instantiates a new tipo contato celular.
     *
     * @param descricao the descricao
     */
    private TipoContatoCelular(String descricao) {
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
