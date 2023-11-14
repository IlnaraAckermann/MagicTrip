package controller.destinos;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.destinos.Destinos;
import model.destinos.DestinosDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ListarDestinos extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ListarDestinos() {}
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	List<Destinos> destinos = new ArrayList<Destinos>();
		DestinosDAO ddao = new DestinosDAO();
		destinos = ddao.listar();
		request.setAttribute("listaDestinos", destinos);

		RequestDispatcher dispatcher = request.getRequestDispatcher("CRUD_menu_destinos.jsp");
		dispatcher.forward(request, response);
	}

}
