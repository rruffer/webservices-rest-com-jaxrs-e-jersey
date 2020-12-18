package br.com.alura.loja.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String buscar() {
		Projeto projeto = projetoDAO.busca(1l);
		return projeto.toXml();
		
	}
	
}
