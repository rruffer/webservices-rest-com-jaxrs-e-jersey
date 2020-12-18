package br.com.alura.loja.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.alura.loja.dao.CarrinhoDAO;
import br.com.alura.loja.dao.ProjetoDAO;
import br.com.alura.loja.modelo.Carrinho;
import br.com.alura.loja.modelo.Projeto;

@Path("carrinhos")
public class CarrinhoResource {
	
	private CarrinhoDAO projetoDAO = new CarrinhoDAO();

	/*	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Response buscar() {
		Carrinho carrinho = carrinhoDAO.busca(1l);
		return Response.ok(carrinho).build();

	}*/
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String buscar() {
		Carrinho carrinho = projetoDAO.busca(1l);
		return carrinho.toXml();
		
	}
	
}
