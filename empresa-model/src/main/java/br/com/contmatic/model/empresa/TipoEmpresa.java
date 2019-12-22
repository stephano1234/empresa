package br.com.contmatic.model.empresa;

/**
 * The Enum TipoEmpresa.
 */
public enum TipoEmpresa {
	
	/** The individual. */
	INDIVIDUAL("Empresário Individual"),
	
	/** The mei. */
	MEI("Microempreendedor Individual"),
	
	/** The eireli. */
	EIRELI("Empresa Individual de Responsabilidade Limitada"),
	
	/** The sociedade. */
	SOCIEDADE("Sociedade Emppresária"),
	
	/** The sociedade simples. */
	SOCIEDADE_SIMPLES("Sociedade Simples");
	
	/** The descricao. */
	private String descricao;
	
	/**
	 * Instantiates a new tipo empresa.
	 *
	 * @param descricao the descricao
	 */
	private TipoEmpresa(String descricao) {
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
