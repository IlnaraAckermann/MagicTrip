package com.magictrip.api.models;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "compra")
public class CompraModel implements Serializable {
    private static final long serialVersionUID = 1;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompra;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private UsuarioModel usuario;

    @ManyToOne
    @JoinColumn(name = "idDestino", nullable = false)
    private DestinoModel destino;

    @ManyToOne
    @JoinColumn(name = "idVendedor")
    private VendedorModel vendedor;

    @Temporal(TemporalType.DATE) // Definindo o tipo de temporalidade
    @Column(name = "data_inicio", nullable = false)
    private Date dataInicio;

    @Temporal(TemporalType.DATE) // Definindo o tipo de temporalidade
    @Column(name = "data_fim", nullable = false)
    private Date dataFim;

    @Column(name = "tipo_pacote", length = 255, nullable = false)
    private String tipoPacote;

    @Column(name = "quatidade_pessoas", length = 255, nullable = false)
    private int qunatidadePessoas;

    @Column(name = "valor", length = 255, nullable = false)
    private Double valor;
}
