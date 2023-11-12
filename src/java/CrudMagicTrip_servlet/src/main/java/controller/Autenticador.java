package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.usuario.UsuarioDAO;

import java.io.IOException;

public class Autenticador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    public Autenticador() { }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String email = request.getParameter("email");
	        String password = request.getParameter("password");
	        boolean isValid = false;
			try {
				isValid = usuarioDAO.autenticarCredenciais(email, password);
			} catch (Exception e) {
				e.printStackTrace();
			}
	        if (isValid) {
	            // Se as credenciais são válidas, redirecionar para a página de listagem
	            response.sendRedirect("./home");
	        } else {
	            // Se as credenciais são inválidas, redirecionar de volta para a página de login
	        	request.setAttribute("loginFailed", true);
	        	RequestDispatcher dispatcher = request.getRequestDispatcher("/");
	            dispatcher.forward(request, response);
	        }
	}

}
