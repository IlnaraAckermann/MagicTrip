package com.magictrip.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Avaliacao_Destino")
public class AvaliacaoDestinoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_avaliacao_vendedor")
    private long idAvaliacaoVendedor;

    @Column(name = "comentario", length = 255)
    private String comentario;

    @Column(name = "nota", nullable = false, length = 2)
    private int nota;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private UsuarioModel usuario;

    @ManyToOne
    @JoinColumn(name = "idDestino", nullable = false)
    private DestinoModel destino;

    public AvaliacaoDestinoModel(int nota, UsuarioModel usuario, DestinoModel destino) {
        this.nota = nota;
        this.usuario = usuario;
        this.destino = destino;
    }

    public AvaliacaoDestinoModel(String comentario, int nota, UsuarioModel usuario, DestinoModel destino) {
        this.comentario = comentario;
        this.nota = nota;
        this.usuario = usuario;
        this.destino = destino;
    }

    public AvaliacaoDestinoModel() {
    }

    public long getIdAvaliacaoVendedor() {
        return idAvaliacaoVendedor;
    }

    public void setIdAvaliacaoVendedor(long idAvaliacaoVendedor) {
        this.idAvaliacaoVendedor = idAvaliacaoVendedor;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

    public DestinoModel getDestino() {
        return destino;
    }

    public void setDestino(DestinoModel destino) {
        this.destino = destino;
    }

}