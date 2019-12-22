package br.com.contmatic.repository;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import br.com.contmatic.model.contato.Email;
import br.com.contmatic.repository.configuracao.Conexao;

public class EmailRepositoryImplementation implements EmailRepository {
	
	private static final String COLLECTION_EMAIL = "email";

	private static final String CAMPO_ENDERECO = "endereco";
	
	private MongoDatabase db;
	
	private MongoCollection<Document> col;
	
	public EmailRepositoryImplementation() {
		Conexao.getInstance();
		db = Conexao.getInstance().getMongoClient().getDatabase("empresa");
		col = db.getCollection(COLLECTION_EMAIL);
	}
	
	@Override
	public void create(Email objeto) {
		Document doc = Document.parse(objeto.toString());
		col.insertOne(doc);
		
	}

	@Override
	public void delete(Email objeto) {
		col.findOneAndDelete(Document.parse(objeto.toString()));
		
	}

	@Override
	public List<Email> query(Filter<Email> filter) {
		List<Email> emailQuery = new ArrayList<>();
		MongoCursor<Document> cursor = col.find().iterator();
		try {
			while (cursor.hasNext()) {
				Email emailToFilter = new Email(cursor.next().get(CAMPO_ENDERECO).toString());
				if (filter.filtered(emailToFilter)) {
					emailQuery.add(emailToFilter);
				}
			}
		} finally {
			cursor.close();
		}
		return emailQuery;
	}

	@Override
	public Email findByEndereco(String endereco) {
		return new Email(col.find(Filters.eq(CAMPO_ENDERECO, endereco)).first().get(CAMPO_ENDERECO).toString());
	}

	@Override
	public String findEnderecoByEmail(Email email) {
		return col.find(Document.parse(email.toString())).first().get(CAMPO_ENDERECO).toString();
	}

	public static void close() {
		Conexao.getInstance().getMongoClient().close();
	}

	@Override
	public long count() {
		return col.countDocuments();
	}

	@Override
	public List<Email> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
