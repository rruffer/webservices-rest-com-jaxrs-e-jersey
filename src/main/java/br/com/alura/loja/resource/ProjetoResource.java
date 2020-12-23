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
import br.com.alura.loja.dao.ProjetoDAO;
import br.com.alura.loja.modelo.Carrinho;
import br.com.alura.loja.modelo.Projeto;

@Path("projetos")
public class ProjetoResource {
	
	private ProjetoDAO projetoDAO = new ProjetoDAO();
	
	/*@GET
	@Produces(MediaType.APPLICATION_XML)
	public String buscar() {
		Projeto projeto = projetoDAO.busca(1l);
		return projeto.toXml();
		
	}*/
	
	@GET
	@Path("{id}")
//	@Produces(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("id") Long id) {
		Projeto projeto = projetoDAO.busca(id);
		return Response.ok(projeto).build();
	}

	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response adicionar(Projeto projeto) {
		projetoDAO.adiciona(projeto);
		return Response.created(URI.create("/projetos/" + projeto.getId())).build();
	}
	
}
