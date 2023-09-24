package entity;

public class Telefone {
    private String telefone_area;
    private String telefone_numero;
    private int id_usuario;
    public String getTelefone_area() {
        return telefone_area;
    }
    public void setTelefone_area(String telefone_area) {
        this.telefone_area = telefone_area;
    }
    public String getTelefone_numero() {
        return telefone_numero;
    }
    public void setTelefone_numero(String telefone_numero) {
        this.telefone_numero = telefone_numero;
    }
    public int getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
    
}
