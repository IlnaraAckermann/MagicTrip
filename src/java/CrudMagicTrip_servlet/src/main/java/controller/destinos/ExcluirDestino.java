package controller.destinos;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.destinos.DestinosDAO;

import java.io.IOException;

public class ExcluirDestino extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExcluirDestino() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		DestinosDAO ddao = new DestinosDAO();
		ddao.deletar(id);

		RequestDispatcher rd = request.getRequestDispatcher("./ListarDestinos");
		rd.forward(request, response);

	}

}
