package model;

import model.usuario.Usuario;

public class AvaliacaoDestino {
    private int nota;
    private String comentario;
    private Destinos destino;
    private Usuario usuario;
    private int id_avalicao_destino;

    public AvaliacaoDestino() {
    }

    public AvaliacaoDestino(int nota, Destinos destino, Usuario usuario) {
        this.nota = nota;
        this.destino = destino;
        this.usuario = usuario;
        this.comentario = null;
    }

    public AvaliacaoDestino(int nota, Destinos destino, Usuario usuario, String comentario) {
        this.nota = nota;
        this.destino = destino;
        this.usuario = usuario;
        this.comentario = comentario;
    }

    public Destinos getDestino() {
        return destino;
    }

    public void setDestino(Destinos destino) {
        this.destino = destino;
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

    public int getId_avalicao_destino() {
        return id_avalicao_destino;
    }

    public void setId_avalicao_destino(int id_avalicao_destino) {
        this.id_avalicao_destino = id_avalicao_destino;
    }

    @Override
    public String toString() {
        return "AvaliacaoDestino [nota=" + nota + ", \ncomentario=" + comentario + ", \ndestino=" + destino.getId_destino()
                + ", \nusuario="
                + usuario.getId_usuario() + ", \nid_avalicao_destino=" + id_avalicao_destino + "]";
    }

}
