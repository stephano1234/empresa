package br.com.contmatic.repository;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

import br.com.contmatic.repository.configuracao.Conexao;

public abstract class CrudMongoDb<T> implements CrudRepository<T> {

	private Class<T> type;
	
	private ObjectMapper mapper;
	
	
	
	private MongoDatabase database;
	
	
	
	private MongoCollection<Document> collection;
	
	@Override
	public void create(T objeto) {
		ObjectMapper mapper = new ObjectMapper();
		//collection.insertOne(objeto.toString());//implement jackson (toString neste tipo generico nao funciona)
	}

	@Override
	public void delete(T objeto) {
		ObjectMapper mapper = new ObjectMapper();
		//collection.deleteOne(objeto.toString());//implement jackson (toString neste tipo generico nao funciona)
	}

	@Override
	public List<T> query(Filter<T> filter) {
		List<T> objetosFiltrados = new ArrayList<>();
		for (T objeto : findAll()) {
			if (filter.filtered(objeto)) {
				objetosFiltrados.add(objeto);
			}
		}
		return objetosFiltrados;
	}
	
	@Override
	public List<T> findAll() {		
		List<T> todosObjetos = new ArrayList<>();
		setDatabase("empresa");
		setCollection("email");
		MongoCursor<Document> cursor = collection.find().iterator();
		configMapper();
		getType();
		try {
			while (cursor.hasNext()) {
				todosObjetos.add(mapper.readValue(cursor.next().toJson(), this.type));//implement jackson
			}
		} catch (JsonProcessingException e) {
			System.out.println(this.type);
			e.printStackTrace();
			return new ArrayList<>();
		} finally {
			cursor.close();
		}
		return todosObjetos;
	}
	
	@Override
	public long count() {
		return collection.countDocuments();
	}
	
	public void close() {
		Conexao.getInstance().getMongoClient().close();
	}
	
	@SuppressWarnings("unchecked")
	public void getType() {
		this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public void setCollection(String lala) {
		this.collection = database.getCollection(lala);
	}

	public void setDatabase(String lala) {
		this.database = Conexao.getInstance().getMongoClient().getDatabase(lala);
	}
	
	public void configMapper() {
		mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	
}
