package controller.usuario;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.usuario.Usuario;
import model.usuario.UsuarioDAO;

import java.io.IOException;

public class CadastrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CadastrarUsuario() { }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// recebendo os dados do formulario via parametro
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
			udao.cadastrar(user);
			// Redirecionando o usuario para a pagina inicial da aplicação.
			request.setAttribute("cadastroRealizado", true);
			RequestDispatcher rd = request.getRequestDispatcher("/");
			rd.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
