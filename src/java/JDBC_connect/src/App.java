import querys.ListarTabelas;

public class App {
    public static void main(String[] args) throws Exception {

        // Criando o usuario e adicionando informações
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
        // chamando a classe UsuarioDao para poder realizar o create no DB
        // new UsuarioDAO().cadastrarUsuario(ilnara);

        // Criando a classe destino e cadastrando o Destino no BD
        // Destinos terraDasFadas = new Destinos();
        // terraDasFadas.setNome("Terra das Fadas");
        // terraDasFadas.setDescricao("Um reino encantado onde fadas dançam entre flores
        // e árvores mágicas.");
        // new DestinoDAO().cadastrarDestino(terraDasFadas);

        // testando querys
        // new ListarTabelas().listarUsuario();
        // new ListarTabelas().listarUsuarioID("1");
        // new ListarTabelas().listarUsuarioName("ilnara");
        // new ListarTabelas().listarUsuarioEmail("ilnara.ackermann@hotmail.com");

        // atualizando o usuario
        // Usuario ilnara = new Usuario();
        // ilnara.setCpf("12345678911");
        // ilnara.setLogradouro("Reino das feras");
        // ilnara.setNumero(456);
        // ilnara.setComplemento(null);
        // ilnara.setCep("12345-698");
        // ilnara.setBairro("Red Dragon");
        // ilnara.setCidade("Alada");
        // ilnara.setEstado("DG");
        // ilnara.setNome_primeiro("Ilnara");
        // ilnara.setNome_meio("Ackermann Ribeiro");
        // ilnara.setNome_ultimo("D Avila");
        // ilnara.setEmail("ilnara.ackermann@hotmail.com");
        // ilnara.setSenha("UmaSenhaQu@lqu3r");
        // chamando a classe UsuarioDao para poder realizar o update no DB
        // new UsuarioDAO().atualizarUsuario(1, ilnara);

        // VERIFICANDO USUARIO ATUALIZADO
        // new ListarTabelas().listarUsuarioID("1");

        // Criando outro usuario e adicionando informações
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
        // chamando a classe UsuarioDao para poder realizar o create no DB
        // new UsuarioDAO().cadastrarUsuario(ilnara);

        // Usuario joao = new Usuario();
        // joao.setCpf("98765432100");
        // joao.setLogradouro("Avenida Principal");
        // joao.setNumero(456);
        // joao.setComplemento("Bloco A");
        // joao.setCep("54321-123");
        // joao.setBairro("Centro");
        // joao.setCidade("Cidade Nova");
        // joao.setEstado("MG");
        // joao.setNome_primeiro("João");
        // joao.setNome_meio("Silva");
        // joao.setNome_ultimo("Santos");
        // joao.setEmail("joao.silva@example.com");
        // joao.setSenha("OutraSenha123");
        // new UsuarioDAO().cadastrarUsuario(joao);

        // new ListarTabelas().listarUsuario();
        
        // new UsuarioDAO().deletarUsuario(2);
        
        // new ListarTabelas().listarUsuario();
        
        // Vendedor vJoao = new Vendedor();
        // vJoao.setUsuario(joao);
        
        // new VendedorDAO().cadastrarVendedor(1);
        
        // new ListarTabelas().listarVendedor();
        // new VendedorDAO().atualizarVendedor(3, 3);
        // System.out.println("-------------");
        // new ListarTabelas().listarVendedor();
        // System.out.println("-------------");
        // new ListarTabelas().listarUsuario();
        // System.out.println("-------------");
        // new ListarTabelas().listarUsuarioID("1");
        // System.out.println("-------------");
        // new ListarTabelas().listarUsuarioEmail("ilnara.ackermann@hotmail.com");
        // System.out.println("-------------");
        // new ListarTabelas().listarUsuarioName("ilnara");
        // System.out.println("-------------");
        // new ListarTabelas().listarVendedorID("3");
        // System.out.println("-------------");
        // new ListarTabelas().listarDestino();
        System.out.println("-------------");
        new ListarTabelas().listarCompras();
        System.out.println("-------------");
        System.out.println("-------------");
        
    }
}
