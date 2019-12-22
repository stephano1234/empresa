package br.com.contmatic.model.pessoa;

/**
 * The Enum TipoContratoTrabalho.
 */
public enum TipoContratoTrabalho {
	
	/** The tempo determinado. */
	TEMPO_DETERMINADO("Contrato de trabalho por tempo determinado"),
	
	/** The tempo indeterminado. */
	TEMPO_INDETERMINADO("Contrato de trabalho por tempo indeterminado"),
	
	/** The temporareo. */
	TEMPORAREO("Contrato de trabalho temporáreo"),
	
	/** The eventual. */
	EVENTUAL("Contrato de trabalho eventual"),
	
	/** The autonomo. */
	AUTONOMO("Contrato de trabalho autônomo"),
	
	/** The estagio. */
	ESTAGIO("Contrato de estágio");
	
	/** The descricao. */
	private String descricao;
	
	/**
	 * Instantiates a new tipo contrato trabalho.
	 *
	 * @param descricao the descricao
	 */
	private TipoContratoTrabalho(String descricao) {
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
