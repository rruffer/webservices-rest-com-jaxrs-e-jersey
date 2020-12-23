package br.com.alura.loja.resources;

import static org.junit.Assert.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.alura.loja.Servidor;
import br.com.alura.loja.modelo.Carrinho;
import br.com.alura.loja.modelo.Projeto;

public class ProjetoResourceTest {
	
	@Before
	public void start() {
		Servidor.inicializarServidor();
	}

	@After
	public void finish() {
		Servidor.finalizarServidor();
	}
	
	@Test
	public void trazCarrinhoEsperado() {
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		Builder request = target.path("/projetos/1").request();
		Projeto projeto = request.get(Projeto.class);
		
		assertEquals("Minha loja", projeto.getNome());
	}

}
