package br.com.contmatic.repository;

import br.com.contmatic.model.contato.Email;

public interface EmailRepository extends CrudRepository<Email> {

	public Email findByEndereco(String endereco);
	
	public String findEnderecoByEmail(Email email);
	
}
