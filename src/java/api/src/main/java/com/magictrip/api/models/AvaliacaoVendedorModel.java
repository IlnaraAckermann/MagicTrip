package com.magictrip.api.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Avaliacao_Vendedor")
public class AvaliacaoVendedorModel implements Serializable {
    private static final long serialVersionUID = 1;
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
    @JoinColumn(name = "idVendedor", nullable = false)
    private VendedorModel vendedor;

    public AvaliacaoVendedorModel(int nota, UsuarioModel usuario, VendedorModel vendedor) {
        this.nota = nota;
        this.usuario = usuario;
        this.vendedor = vendedor;
    }

    public AvaliacaoVendedorModel(String comentario, int nota, UsuarioModel usuario, VendedorModel vendedor) {
        this.comentario = comentario;
        this.nota = nota;
        this.usuario = usuario;
        this.vendedor = vendedor;
    }

    public AvaliacaoVendedorModel() {
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

    public VendedorModel getVendedor() {
        return vendedor;
    }

    public void setVendedor(VendedorModel vendedor) {
        this.vendedor = vendedor;
    }

}