package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import connect.Connect;
import entity.Usuario;

public class UsuarioDAO {
    public void cadastrarUsuario (Usuario usuario){
        String sql = "INSERT INTO USUARIO ( CPF, LOGRADOURO, NUMERO, COMPLEMENTO, CEP, BAIRRO, CIDADE, ESTADO, NOME_PRIMEIRO, NOME_MEIO, NOME_ULTIMO, EMAIL, SENHA) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = null;
        try{
            ps = Connect.getConnection().prepareStatement(sql);
            ps.setString(1, usuario.getCpf());
            ps.setString(2, usuario.getLogradouro());
            ps.setInt(3, usuario.getNumero());
            ps.setString(4, usuario.getComplemento());
            ps.setString(5, usuario.getCep());
            ps.setString(6, usuario.getBairro());
            ps.setString(7, usuario.getCidade());
            ps.setString(8, usuario.getEstado());
            ps.setString(9, usuario.getNome_primeiro());
            ps.setString(10, usuario.getNome_meio());
            ps.setString(11, usuario.getNome_ultimo());
            ps.setString(12, usuario.getEmail());
            ps.setString(13, usuario.getSenha());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
