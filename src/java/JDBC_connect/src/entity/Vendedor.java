package entity;

public class Vendedor {
    private int id_vendedor;
    private Usuario usuario;

    @Override
    public String toString() {
        return "Vendedor [id_vendedor=" + id_vendedor + ", usuario=" + usuario + "]";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(int id_vendedor) {
        this.id_vendedor = id_vendedor;
    }
}
