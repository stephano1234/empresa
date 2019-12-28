package br.com.contmatic.utilidades;

public enum TipoEnum {

	VALOR(1, "valor");
	
	private int numero;
	
	private String texto;
	
	private TipoEnum(int numero, String texto) {
		this.numero = numero;
		this.texto = texto;
	}

	public int getNumero() {
		return numero;
	}

	public String getTexto() {
		return texto;
	}
	
}
