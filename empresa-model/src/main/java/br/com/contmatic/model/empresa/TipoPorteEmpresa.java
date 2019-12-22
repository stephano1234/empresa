package br.com.contmatic.model.empresa;

/**
 * The Enum TipoPorteEmpresa.
 */
public enum TipoPorteEmpresa {
	
	/** The me. */
	ME("Microempresa"),
	
	/** The epp. */
	EPP("Empresa de pequeno porte"),
	
	/** The medio. */
	MEDIO("Empresa de médio porte"),
	
	/** The grande. */
	GRANDE("Empresa de grande porte");
	
	/** The descricao. */
	private String descricao;
	
	/**
	 * Instantiates a new tipo porte empresa.
	 *
	 * @param descricao the descricao
	 */
	private TipoPorteEmpresa(String descricao) {
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
