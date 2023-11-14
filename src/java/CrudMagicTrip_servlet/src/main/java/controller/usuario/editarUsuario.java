package controller.usuario;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.usuario.Usuario;
import model.usuario.UsuarioDAO;

import java.io.IOException;

public class editarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public editarUsuario() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		try {
			UsuarioDAO udao = new UsuarioDAO();
			Usuario usuario = udao.listarPorID(id);

			request.setAttribute("user", usuario);

			RequestDispatcher rd = request.getRequestDispatcher("./editausuario.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// recebendo os dados do formulario via parametro
		int id  = Integer.parseInt(request.getParameter("id"));
		String cpf = request.getParameter("cpf");
		String logradouro = request.getParameter("logradouro");
		int numero = Integer.parseInt(request.getParameter("numero"));
		String complemento = request.getParameter("complemento");
		String cep = request.getParameter("cep");
		String bairro = request.getParameter("bairro");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String dataNascimento = request.getParameter("dataNascimento");

		// criando o objeto contato
		Usuario user = new Usuario();

		// guardando os dados do formulario do objeto
		user.setId_usuario(id);
		user.setCpf(cpf);
		user.setLogradouro(logradouro);
		user.setNumero(numero);
		user.setComplemento(complemento);
		user.setCep(cep);
		user.setBairro(bairro);
		user.setCidade(cidade);
		user.setEstado(estado);
		user.setNome(nome);
		user.setEmail(email);
		user.setSenha(senha);
		user.setDataNascimento(dataNascimento);

		// criando um objeto DAO para enviar o objeto Contato para o banco de dados
		// usando o método save da classe ContatoDA
		try {
			UsuarioDAO udao = new UsuarioDAO();
			udao.atualizar(user);
			//RequestDispatcher rd = request.getRequestDispatcher("/home");
//			rd.forward(request, response);
			response.sendRedirect("./ListarUsuarios");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
