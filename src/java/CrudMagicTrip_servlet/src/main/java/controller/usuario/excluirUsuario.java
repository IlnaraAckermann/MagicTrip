package controller.usuario;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.usuario.UsuarioDAO;

import java.io.IOException;

public class excluirUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public excluirUsuario() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		try {
			UsuarioDAO udao = new UsuarioDAO();
			udao.deletar(id);

			RequestDispatcher rd = request.getRequestDispatcher("./home");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
