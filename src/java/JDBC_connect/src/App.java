import DAO.DestinoDAO;
import DAO.UsuarioDAO;
import entity.Destinos;
import entity.Usuario;
import querys.ListarUsuarios;

public class App {
    public static void main(String[] args) throws Exception {


        //Criando o usuario e adicionando informações
        // Usuario ilnara = new Usuario();
        // ilnara.setCpf("12345678911");
        // ilnara.setLogradouro("Rua da Alegria");
        // ilnara.setNumero(123);
        // ilnara.setComplemento(null);
        // ilnara.setCep("12345-698");
        // ilnara.setBairro("Magico");
        // ilnara.setCidade("Encantada");
        // ilnara.setEstado("OP");
        // ilnara.setNome_primeiro("Ilnara");
        // ilnara.setNome_meio("Ackermann Ribeiro");
        // ilnara.setNome_ultimo("D Avila");
        // ilnara.setEmail("ilnara.ackermann@hotmail.com");
        // ilnara.setSenha("UmaSenhaQu@lqu3r");
        //chamando a classe UsuarioDao para poder realizar o create no DB
        // new UsuarioDAO().cadastrarUsuario(ilnara);


        //Criando a classe destino e cadastrando o Destino no BD
        // Destinos terraDasFadas = new Destinos();
        // terraDasFadas.setNome("Terra das Fadas");
        // terraDasFadas.setDescricao("Um reino encantado onde fadas dançam entre flores e árvores mágicas.");
        // new DestinoDAO().cadastrarDestino(terraDasFadas);
new ListarUsuarios().listarUsuario();

        
        
    }
}
