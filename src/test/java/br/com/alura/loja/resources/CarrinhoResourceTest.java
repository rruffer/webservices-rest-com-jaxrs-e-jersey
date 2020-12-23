package br.com.alura.loja.resources;

import static org.junit.Assert.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.grizzly.http.util.HttpStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.alura.loja.Servidor;
import br.com.alura.loja.modelo.Carrinho;
import br.com.alura.loja.modelo.Produto;

public class CarrinhoResourceTest {
	
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
		Builder request = target.path("/carrinhos/1").request();
		Carrinho carrinho = request.get(Carrinho.class);

		System.out.println(carrinho);
		
		assertEquals("Rua Vergueiro 3185, 8 andar", carrinho.getRua());
	}
	
	@Test
	public void salvarCarrinho() {
		Produto videogame = new Produto(6237, "Videogame 4", 4000, 1);
		Carrinho carrinho = new Carrinho()
								.adiciona(videogame)
								.para("Rua Petter Lund", "S�o Paulo")
								.setId(2l);
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080");
		Builder request = target.path("/carrinhos").request();
		Response response = request.post(Entity.entity(carrinho, MediaType.APPLICATION_JSON));
		
		assertEquals(response.getStatus(), HttpStatus.CREATED_201.getStatusCode());
		
	}

}
