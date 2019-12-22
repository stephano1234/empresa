package br.com.contmatic.repository;

import java.util.List;

public interface CrudRepository<T> {

	void create(T objeto);
	
	public default void createMany(List<T> objetos) {
		objetos.forEach(this::create);
	}

	void delete(T objeto);
	
	public default void deleteMany(List<T> objetos) {
		objetos.forEach(this::delete);
	}

	List<T> query(Filter<T> filter);
	
	List<T> findAll();
	
	long count();
		
}
