package br.com.contmatic.repository;

import br.com.contmatic.model.contato.Email;

public class EmailPontoComFilter implements Filter<Email> {

	@Override
	public boolean filtered(Email objeto) {
		return objeto.getEndereco().replaceAll(".*\\.(?!.*\\.)", "").equals("com");
	}

}
