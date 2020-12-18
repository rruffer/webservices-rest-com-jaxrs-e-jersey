package client;

import static org.junit.Assert.assertTrue;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;

import org.junit.Test;

public class ClientTest {

	@Test
	public void testQueAConexaoComOServidorFunciona() {
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://www.mocky.io");
		Builder request = target.path("/v2/52aaf5deee7ba8c70329fb7d").request();
		String conteudo = request.get(String.class);

		System.out.println(conteudo);
		
		assertTrue(conteudo.contains("<rua>Rua Vergueiro 3185"));
		
		
	}

}
