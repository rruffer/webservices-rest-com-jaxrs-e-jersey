package br.com.alura.loja.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import br.com.alura.loja.modelo.Projeto;

public class ProjetoDAO implements Dao<Projeto>{
	
	private static Map<Long, Projeto> banco = new HashMap<>();
	private static AtomicLong contador = new AtomicLong(1);
	
	static {
		banco.put(1l, new Projeto(1l, "Minha loja", 2014));
		banco.put(2l, new Projeto(2l, "Alura", 2012));
	}
	
	@Override
	public void adiciona(Projeto projeto) {
		long id = contador.incrementAndGet();
		projeto.setId(id);
		banco.put(id, projeto);
	}
	
	@Override
	public Projeto busca(Long id) {
		return banco.get(id);
	}
	
	@Override
	public Projeto remove(long id) {
		return banco.remove(id);
	}

}
