package br.com.alura.loja.dao;

public interface Dao<T> {

	void adiciona(T obj);
	T busca(Long id);
	T remove(long id);
}
