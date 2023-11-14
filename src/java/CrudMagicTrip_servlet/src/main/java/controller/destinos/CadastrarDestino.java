package controller.destinos;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.destinos.Destinos;
import model.destinos.DestinosDAO;

import java.io.IOException;

public class CadastrarDestino extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CadastrarDestino() {}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		
		Destinos destino = new Destinos();
		destino.setDescricao(descricao);
		destino.setNome(nome);
		try {
			DestinosDAO ddao = new DestinosDAO();
			ddao.cadastrar(destino);
			response.sendRedirect("./ListarDestinos");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
