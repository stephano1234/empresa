package br.com.contmatic.repository;

public interface Filter<T> {

	boolean filtered(T objeto);
	
}
