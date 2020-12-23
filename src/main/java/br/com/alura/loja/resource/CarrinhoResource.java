package br.com.alura.loja.resource;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.alura.loja.dao.CarrinhoDAO;
import br.com.alura.loja.modelo.Carrinho;

@Path("carrinhos")
public class CarrinhoResource {

	private CarrinhoDAO carrinhoDAO = new CarrinhoDAO();

	@GET
	@Path("{id}")
//	@Produces(MediaType.APPLICATION_XML)
//	@Produces(MediaType.APPLICATION_JSON + "; charset=UTF-8")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("id") Long id) {
		Carrinho carrinho = carrinhoDAO.busca(id);
		return Response.ok(carrinho).link("/carrinhos/" + id, "rel").build();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response adicionar(Carrinho carrinho) {
		carrinhoDAO.adiciona(carrinho);
		return Response.created(URI.create("/carrinho/" + carrinho.getId())).build();
	}

	/*
	 * @GET
	 * 
	 * @Produces(MediaType.APPLICATION_XML) public String buscar() { Carrinho
	 * carrinho = projetoDAO.busca(1l); return carrinho.toXml();
	 * 
	 * }
	 */

}
