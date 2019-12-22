package teste;

import br.com.contmatic.model.contato.Email;
import br.com.contmatic.repository.CrudMongoDb;
import br.com.contmatic.repository.CrudRepository;
import br.com.contmatic.repository.EmailPontoComFilter;
import br.com.contmatic.repository.EmailRepositoryImplementation;
import br.com.contmatic.repository.Filter;

public class Testeconecta {

	public static void main(String[] args) {
		Filter<Email> emailPontoComFilter = new EmailPontoComFilter();
		EmailRepositoryImplementation emailRepositoryImplementation = new EmailRepositoryImplementation();
		System.out.println(emailRepositoryImplementation.count());
		emailRepositoryImplementation.create(new Email("lalala@hotmail.com"));
		System.out.println(emailRepositoryImplementation.count());
		System.out.println("1:" + emailRepositoryImplementation.findByEndereco("lalala@hotmail.com"));
		System.out.println("2:" + emailRepositoryImplementation.query(emailPontoComFilter));
		System.out.println("3:" + emailRepositoryImplementation.query(new EmailPontoComFilter()));
		System.out.println("4:" + emailRepositoryImplementation.query(new Filter<Email>() {
			@Override
			public boolean filtered(Email objeto) {
				return objeto.getEndereco().replaceAll(".*\\.(?!.*\\.)", "").equals("com");
			}
		}));
		System.out.println("5:" + emailRepositoryImplementation.query(objeto -> objeto.getEndereco().replaceAll(".*\\.(?!.*\\.)", "").equals("com")));
		CrudRepository<Email> buscaEmail = new EmailRepositoryImplementation();
		System.out.println("6:" + buscaEmail.query(email -> email.getEndereco().replaceAll(".*\\.(?!.*\\.)", "").equals("com")));
	    CrudMongoDb<Email> busca = new CrudMongoDb<Email>() {
	    	
		};
		System.out.println(busca.query(emailPontoComFilter));
		emailRepositoryImplementation.delete(new Email("lalala@hotmail.com"));
		System.out.println(emailRepositoryImplementation.count());
		EmailRepositoryImplementation.close();
	}

}
