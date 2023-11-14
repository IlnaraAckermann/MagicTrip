package controller.usuario;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.usuario.Usuario;
import model.usuario.UsuarioDAO;

@WebServlet("/ListarUsuarios")
public class ListaUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ListaUsuarios() {};
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Usuario> users = new ArrayList<Usuario>();
		UsuarioDAO udao = new UsuarioDAO();
		users = udao.listar();
		request.setAttribute("listaUsuarios", users);

		RequestDispatcher dispatcher = request.getRequestDispatcher("./CRUD_menu_usuario.jsp");
		dispatcher.forward(request, response);
	}

}
