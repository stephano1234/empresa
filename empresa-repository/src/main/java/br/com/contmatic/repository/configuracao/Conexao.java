package br.com.contmatic.repository.configuracao;

import static br.com.contmatic.repository.configuracao.ConstantesConfig.HOST_NAME;
import static br.com.contmatic.repository.configuracao.ConstantesConfig.PORTA;

import com.mongodb.MongoClient;

public final class Conexao {
	
	private static Conexao instance;
	
	private MongoClient mongoClient;
	
	private Conexao() {	
		this.mongoClient = new MongoClient(HOST_NAME, PORTA);
	}
	
	public static synchronized Conexao getInstance() {
		if (instance == null) {
			instance = new Conexao();
		}
		return instance;
	}
	
	public MongoClient getMongoClient() {
		return this.mongoClient;
	}
	
}
