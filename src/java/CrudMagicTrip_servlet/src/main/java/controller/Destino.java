package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.usuario.Usuario;
import model.usuario.UsuarioDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Destino extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Destino() {}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<Usuario> users = new ArrayList<Usuario>();
		UsuarioDAO udao = new UsuarioDAO();
		users = udao.listar();
		request.setAttribute("listaUsuarios", users);

		RequestDispatcher dispatcher = request.getRequestDispatcher("CRUD_menu.jsp");
		dispatcher.forward(request, response);
	}

}
