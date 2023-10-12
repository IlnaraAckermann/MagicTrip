import java.math.BigDecimal;
import java.sql.Date;

import java.util.Scanner;

import DAO.*;
import model.*;

public class App {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {

        while (true) {
            MostrarMenu();
        }  
            
    }

    public static void MostrarMenu() {
        System.out.println(
                "Escolha uma opção \n1 Usuarios \n2 Destinos \n3 Vendedores \n4 Compras \n5 Avaliações de Vendedores \n6 Avaliações de Destinos \n7 Sair");
        int op = scanner.nextInt();
        switch (op) {
            case 1:
                MostrarMenuUsuarios();
                break;
            case 2:
                MostrarMenuDestinos();
                break;
            case 3:
                MostrarMenuVendedores();
                break;
            case 4:
            MostrarMenuCompras();
                break;
            case 5:
                MostrarMenuAvaliacaoVendedor();
                break;
            case 6:
                MostrarMenuAvaliacaoDestino();
                break;
            case 7:
                System.out.println("Saindo do menu.");
                scanner.close();
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
                break;
        }

    }


    //----- METODOS MENU USUARIO

    private static void MostrarMenuUsuarios() {
        while (true) {
            System.out.println(
                "Escolha uma opção \n1 Cadastrar novo usuário \n2 Atualizar Usuário Existente \n3 Deletar Usuario \n4 Listar usuários \n5 Sair");
                int op = scanner.nextInt();
                
                switch (op) {
                case 1:
                    CriarNovoUsuario();
                    break;
                case 2:
                    AtualizarUsuario();
                    break;
                case 3:
                    System.out.println("Digite o ID do usuário a ser deletado");
                    int id = scanner.nextInt();
                    System.out.println("Deletando usuário de ID " + id);
                    new UsuarioDAO().deletar(id);
                    break;
                case 4:
                    new UsuarioDAO().listar();
                    break;
                case 5:
                    System.out.println("Saindo do menu de usuários.");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    };

    private static void CriarNovoUsuario() {
        System.out.println("Informe os dados para criar um novo usuário:");

        System.out.print("CPF: ");
        String cpf = scanner.next();

        System.out.print("Logradouro: ");
        String logradouro = scanner.next();

        System.out.print("Número: ");
        int numero = scanner.nextInt();

        System.out.print("Complemento: ");
        String complemento = scanner.next();

        System.out.print("CEP: ");
        String cep = scanner.next();

        System.out.print("Bairro: ");
        String bairro = scanner.next();

        System.out.print("Cidade: ");
        String cidade = scanner.next();

        System.out.print("Estado: ");
        String estado = scanner.next();

        System.out.print("Primeiro Nome: ");
        String nome_primeiro = scanner.next();

        System.out.print("Nome do Meio: ");
        String nome_meio = scanner.next();

        System.out.print("Último Nome: ");
        String nome_ultimo = scanner.next();

        System.out.print("Email: ");
        String email = scanner.next();

        System.out.print("Senha: ");
        String senha = scanner.next();

        Usuario novoUsuario = new Usuario(cpf, logradouro, numero, complemento, cep, bairro, cidade, estado,
                nome_primeiro, nome_meio, nome_ultimo, email, senha);

        new UsuarioDAO().cadastrar(novoUsuario);
    }

    private static void AtualizarUsuario() {
        System.out.println("Qual o id do usuário a ser atualizado");
        int id = scanner.nextInt();
        System.out.println("Informe os dados para atualizar usuário:" + id);

        System.out.print("CPF: ");
        String cpf = scanner.next();

        System.out.print("Logradouro: ");
        String logradouro = scanner.next();

        System.out.print("Número: ");
        int numero = scanner.nextInt();

        System.out.print("Complemento: ");
        String complemento = scanner.next();

        System.out.print("CEP: ");
        String cep = scanner.next();

        System.out.print("Bairro: ");
        String bairro = scanner.next();

        System.out.print("Cidade: ");
        String cidade = scanner.next();

        System.out.print("Estado: ");
        String estado = scanner.next();

        System.out.print("Primeiro Nome: ");
        String nome_primeiro = scanner.next();

        System.out.print("Nome do Meio: ");
        String nome_meio = scanner.next();

        System.out.print("Último Nome: ");
        String nome_ultimo = scanner.next();

        System.out.print("Email: ");
        String email = scanner.next();

        System.out.print("Senha: ");
        String senha = scanner.next();

        Usuario novoUsuario = new Usuario(cpf, logradouro, numero, complemento, cep, bairro, cidade, estado,
                nome_primeiro, nome_meio, nome_ultimo, email, senha);

        new UsuarioDAO().atualizar(id, novoUsuario);
    }


    //----- METODOS MENU DESTINO
    private static void MostrarMenuDestinos() {
        while (true) {
            System.out.println(
                "Escolha uma opção \n1 Cadastrar novo destino \n2 Atualizar destino Existente \n3 Deletar destino \n4 Listar destinos \n5 Sair");
                int op = scanner.nextInt();
                
                switch (op) {
                case 1:
                    CriarNovoDestino();
                    break;
                case 2:
                    AtualizarDestino();
                    break;
                case 3:
                    System.out.println("Digite o ID do destino a ser deletado");
                    int id = scanner.nextInt();
                    System.out.println("Deletando usuário de ID " + id);
                    new DestinoDAO().deletar(id);
                    break;
                case 4:
                    new DestinoDAO().listar();
                    break;
                case 5:
                    System.out.println("Saindo do menu de destino.");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private static void AtualizarDestino() {
        System.out.println("Qual o id do destino a ser atualizado");
        int id = scanner.nextInt();
        System.out.println("Informe os dados para atualizar o destino:");

        System.out.print("nome: ");
        String nome = scanner.next();

        System.out.print("Descrição: ");
        String descricao = scanner.next();
        new DestinoDAO().atualizar(id, nome, descricao);
    }

    private static void CriarNovoDestino() {
        System.out.println("Informe os dados para criar um novo destino:");

        System.out.print("nome: ");
        String nome = scanner.next();

        System.out.print("Descrição: ");
        String descricao = scanner.next();

        Destinos novoDestino = new Destinos(nome, descricao);

        new DestinoDAO().cadastrar(novoDestino);

    };


    //----- METODOS MENU VENDEDORES
    private static void MostrarMenuVendedores() {
        while (true) {
            System.out.println(
                "Escolha uma opção \n1 Cadastrar novo vendedor \n2 Atualizar vendedor Existente \n3 Deletar vendedor \n4 Listar vendedor \n5 Sair");
                int op = scanner.nextInt();
                
                switch (op) {
                case 1:
                    CriarNovoVendedor();
                    break;
                case 2:
                    AtualizarVendedor();
                    break;
                case 3:
                    System.out.println("Digite o ID do vendedor a ser deletado");
                    int id = scanner.nextInt();
                    System.out.println("Deletando vendedor de ID " + id);
                    new VendedorDAO().deletar(id);
                    break;
                case 4:
                    new VendedorDAO().listar();
                    break;
                case 5:
                    System.out.println("Saindo do menu de vendedor.");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private static void CriarNovoVendedor() {
        System.out.println("Informe os dados para criar um novo vendedor:");
        System.out.print("Id do usuario: ");
        int id = scanner.nextInt();
        new VendedorDAO().cadastrar(id);
    }

    private static void AtualizarVendedor() {
        System.out.println("Qual o id do vendedor a ser atualizado");
        int id = scanner.nextInt();
        System.out.println("Informe os dados para atualizar o vendedor:");

        System.out.print("Id do usuario: ");
        int id_usuario = scanner.nextInt();
        new VendedorDAO().atualizar(id, id_usuario);
    }


    //----- METODOS MENU COMPRAS
    private static void MostrarMenuCompras() {
        while (true) {
            System.out.println(
                "Escolha uma opção \n1 Cadastrar nova compra \n2 Atualizar compra Existente \n3 Deletar compra \n4 Listar compras \n5 Sair");
                int op = scanner.nextInt();
                
                switch (op) {
                case 1:
                    CriarNovaCompra();
                    break;
                case 2:
                    AtualizarCompra();
                    break;
                case 3:
                    System.out.println("Digite o ID da compra a ser deletado");
                    int id = scanner.nextInt();
                    System.out.println("Deletando compra de ID " + id);
                    new CompraDAO().deletar(id);
                    break;
                case 4:
                    new CompraDAO().listar();
                    break;
                case 5:
                    System.out.println("Saindo do menu de compras.");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private static void CriarNovaCompra() {

        
        System.out.println("Informe os dados para criar uma nova compra:");        
        System.out.println("Digite o valor da compra:");
        BigDecimal valor = scanner.nextBigDecimal();
        System.out.println("Digite a quantidade de pessoas:");
        int qnt_pessoas = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o tipo de pacote:");
        String tipo_pacote = scanner.nextLine();
        System.out.println("Digite o valor da comissão:");
        BigDecimal comissao = scanner.nextBigDecimal();
        System.out.println("Digite a data de fim (no formato 'yyyy-MM-dd'):");
        String dataFimStr = scanner.next();
        Date data_fim = Date.valueOf(dataFimStr);
        System.out.println("Digite a data de início (no formato 'yyyy-MM-dd'):");
        String dataInicioStr = scanner.next();
        Date data_inicio = Date.valueOf(dataInicioStr);
        System.out.println("Digite o ID do destino");
        int id_destino = scanner.nextInt();
        System.out.println("Digite o ID do usuario");
        int id_usuario = scanner.nextInt();
        System.out.println("Digite o ID do vendedor");
        int id_vendedor = scanner.nextInt();

        Usuario usuario = new UsuarioDAO().criarExistentePorID(id_usuario);
        Vendedor vendedor = new VendedorDAO().criarExistentePorID(id_vendedor);
        Destinos destino = new DestinoDAO().criarExistentePorID(id_destino);

        Compra compra = new Compra(valor, qnt_pessoas, tipo_pacote, comissao, data_fim, data_inicio, destino, usuario, vendedor);
        new CompraDAO().cadastrar(compra);
    }

    private static void AtualizarCompra() {
        System.out.println("Qual o id da compra a ser atualizado");
        int id = scanner.nextInt();
        System.out.println("Informe os dados para atualizar a compra:");
        System.out.println("Digite o valor da compra:");
        BigDecimal valor = scanner.nextBigDecimal();
        System.out.println("Digite a quantidade de pessoas:");
        int qnt_pessoas = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Digite o tipo de pacote:");
        String tipo_pacote = scanner.nextLine();
        System.out.println("Digite o valor da comissão:");
        BigDecimal comissao = scanner.nextBigDecimal();
        System.out.println("Digite a data de fim (no formato 'yyyy-MM-dd'):");
        String dataFimStr = scanner.next();
        Date data_fim = Date.valueOf(dataFimStr);
        System.out.println("Digite a data de início (no formato 'yyyy-MM-dd'):");
        String dataInicioStr = scanner.next();
        Date data_inicio = Date.valueOf(dataInicioStr);
        System.out.println("Digite o ID do destino");
        int id_destino = scanner.nextInt();
        System.out.println("Digite o ID do usuario");
        int id_usuario = scanner.nextInt();
        System.out.println("Digite o ID do vendedor");
        int id_vendedor = scanner.nextInt();

        Usuario usuario = new UsuarioDAO().criarExistentePorID(id_usuario);
        Vendedor vendedor = new VendedorDAO().criarExistentePorID(id_vendedor);
        Destinos destino = new DestinoDAO().criarExistentePorID(id_destino);

        Compra compra = new Compra(valor, qnt_pessoas, tipo_pacote, comissao, data_fim, data_inicio, destino, usuario, vendedor);
        new CompraDAO().atualizar(compra, id);

    }

    //----- METODOS MENU AVALIAÇÃO DE VENDEDORES
    private static void MostrarMenuAvaliacaoVendedor() {
        while (true) {
            System.out.println(
                "Escolha uma opção \n1 Cadastrar nova avaliação de vendedor \n2 Atualizar avaliação de vendedor Existente \n3 Deletar avaliação de vendedor \n4 Listar todas as avaliações de vendedores \n5 Sair");
                int op = scanner.nextInt();
                
                switch (op) {
                case 1:
                    CriarNovaAvaliacaoVendedor();
                    break;
                case 2:
                    AtualizarAvaliacaoVendedor();
                    break;
                case 3:
                    System.out.println("Digite o ID da Avaliação de vendedor a ser deletada");
                    int id = scanner.nextInt();
                    System.out.println("Deletando Avaliacao Vendedor de ID " + id);
                    new AvalicaoVendedorDAO().deletar(id);
                    break;
                case 4:
                    new AvalicaoVendedorDAO().listar();
                    break;
                case 5:
                    System.out.println("Saindo do menu de avaliação de vendedor.");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private static void CriarNovaAvaliacaoVendedor() {
        System.out.println("Informe os dados para criar uma nova avaliacao de vendedor:");
        System.out.print("Nota: ");
        int nota = scanner.nextInt();
        System.out.print("Digite id do usuário a ser avaliado: ");
        int id_usuario = scanner.nextInt();
        System.out.print("Digite o id vendedor que esta avaliando: ");
        int id_vendedor = scanner.nextInt();
        System.out.print("Digite o comentário: ");
        String comentario = scanner.nextLine();
        Usuario usuario = new UsuarioDAO().criarExistentePorID(id_usuario);
        Vendedor vendedor = new VendedorDAO().criarExistentePorID(id_vendedor);
        AvaliacaoVendedor avaliacao = new AvaliacaoVendedor(nota, vendedor, usuario, comentario);
        new AvalicaoVendedorDAO().cadastrar(avaliacao);
    }

    private static void AtualizarAvaliacaoVendedor() {
        System.out.println("Qual o id da Avaliação de vendedor a ser atualizado");
        int id = scanner.nextInt();
        System.out.println("Informe os dados para atualizar a avaliação:");
        System.out.print("Nota: ");
        int nota = scanner.nextInt();
        System.out.print("Digite o comentário: ");
        String comentario = scanner.nextLine();
        new AvalicaoVendedorDAO().atualizar(comentario, nota, id);
    }

    //----- METODOS MENU AVALIAÇÃO DE Destinos
    private static void MostrarMenuAvaliacaoDestino() {
        while (true) {
            System.out.println(
                "Escolha uma opção \n1 Cadastrar nova avaliação de destino \n2 Atualizar avaliação de destino Existente \n3 Deletar avaliação de destino \n4 Listar todas as avaliações de destino \n5 Sair");
                int op = scanner.nextInt();
                
                switch (op) {
                case 1:
                    CriarNovaAvaliacaoDestino();
                    break;
                case 2:
                    AtualizarAvaliacaoDestino();
                    break;
                case 3:
                    System.out.println("Digite o ID da Avaliação de Destino a ser deletada");
                    int id = scanner.nextInt();
                    System.out.println("Deletando Avaliacao Destino de ID " + id);
                    new AvalicaoDestinoDAO().deletar(id);
                    break;
                case 4:
                    new AvalicaoDestinoDAO().listar();
                    break;
                case 5:
                    System.out.println("Saindo do menu de avaliação de Destino.");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private static void CriarNovaAvaliacaoDestino() {
        System.out.println("Informe os dados para criar uma nova avaliacao de destino:");
        System.out.print("Nota: ");
        int nota = scanner.nextInt();
        System.out.print("Digite id do destino a ser avaliado: ");
        int id_destino = scanner.nextInt();
        System.out.print("Digite o id usuário que esta avaliando: ");
        int id_usuario = scanner.nextInt();
        System.out.print("Digite o comentário: ");
        String comentario = scanner.nextLine();
        Usuario usuario = new UsuarioDAO().criarExistentePorID(id_usuario);
        Destinos destino = new DestinoDAO().criarExistentePorID(id_destino);
        AvaliacaoDestino avaliacao = new AvaliacaoDestino(nota, destino, usuario, comentario);
        new AvalicaoDestinoDAO().cadastrar(avaliacao);
    }

    private static void AtualizarAvaliacaoDestino() {
        System.out.println("Qual o id da Avaliação de destino a ser atualizado");
        int id = scanner.nextInt();
        System.out.println("Informe os dados para atualizar a avaliação:");
        System.out.print("Nota: ");
        int nota = scanner.nextInt();
        System.out.print("Digite o comentário: ");
        String comentario = scanner.nextLine();
        new AvalicaoDestinoDAO().atualizar(comentario, nota, id);
    }

}
