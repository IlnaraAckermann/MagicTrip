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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Avaliacao_Destino")
public class AvaliacaoDestinoModel implements Serializable {
    private static final long serialVersionUID = 1;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_avaliacao_vendedor")
    private int idAvaliacaoVendedor;

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


    public DestinoModel getDestino() {
        return destino;
    }

    public void setDestino(DestinoModel destino) {
        this.destino = destino;
    }

}