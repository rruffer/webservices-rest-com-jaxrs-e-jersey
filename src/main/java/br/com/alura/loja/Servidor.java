package br.com.alura.loja;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * xml rest - https://howtodoinjava.com/jaxb/jaxb-annotations/
 * @author rodolfo.ruffer
 *
 */
public class Servidor {

	private static HttpServer server;

	public static void main(String[] args) throws IOException {

		inicializarServidor();
		System.out.println("Servidor rodando!");
		System.in.read();
		finalizarServidor();

	}

	public static void finalizarServidor() {
		server.stop();
	}

	public static void inicializarServidor() {
		URI uri = URI.create("http://localhost:8080/");
		ResourceConfig config = new ResourceConfig()
				.packages("br.com.alura.loja")
		/* .register(DeclarativeLinkingFeature.class) */;
		server = GrizzlyHttpServerFactory.createHttpServer(uri, config);
	}

}
