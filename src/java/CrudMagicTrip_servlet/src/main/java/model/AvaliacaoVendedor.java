package model;

import model.usuario.Usuario;

public class AvaliacaoVendedor {
    private int nota;
    private String comentario;
    private Usuario usuario;
    private Vendedor vendedor;
    private int id_avalicao_vendedor;

    public AvaliacaoVendedor() {
    }

    public AvaliacaoVendedor(int nota, Vendedor vendedor, Usuario usuario) {
        this.nota = nota;
        this.vendedor = vendedor;
        this.usuario = usuario;
        this.comentario = null;
    }

    public AvaliacaoVendedor(int nota, Vendedor vendedor, Usuario usuario, String comentario) {
        this.nota = nota;
        this.vendedor = vendedor;
        this.usuario = usuario;
        this.comentario = comentario;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getId_avalicao_vendedor() {
        return id_avalicao_vendedor;
    }

    public void setId_avalicao_vendedor(int id_avalicao_vendedor) {
        this.id_avalicao_vendedor = id_avalicao_vendedor;
    }

    @Override
    public String toString() {
        return "AvaliacaoVendedor [nota=" + nota + ", \ncomentario=" + comentario + ", \nusuario=" + usuario.getId_usuario()
                + ", \nvendedor="
                + vendedor.getId_vendedor() + ", \nid_avalicao_vendedor=" + id_avalicao_vendedor + "]";
    }

}
