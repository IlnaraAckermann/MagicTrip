package controller.destinos;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.destinos.Destinos;
import model.destinos.DestinosDAO;

import java.io.IOException;

public class EditarDestino extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public EditarDestino() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			DestinosDAO ddao = new DestinosDAO();
			Destinos destino = ddao.listarPorID(id);
			
			request.setAttribute("destino", destino);
			
			RequestDispatcher rd = request.getRequestDispatcher("./editardestino.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id  = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		
		Destinos destino = new Destinos();
		
		destino.setId_destino(id);
		destino.setNome(nome);
		destino.setDescricao(descricao);
		
		try {
			DestinosDAO ddao = new DestinosDAO();
			ddao.atualizar(destino);
			response.sendRedirect("./ListarDestinos");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
