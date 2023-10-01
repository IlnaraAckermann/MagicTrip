package entity;

public class Telefone {
    private String telefone_area;
    private String telefone_numero;
    private Usuario usuario;

    @Override
    public String toString() {
        return "Telefone [telefone_area=" + telefone_area + ", telefone_numero=" + telefone_numero + ", usuario="
                + usuario + "]";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

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

}
