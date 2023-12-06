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
@Table(name = "vendedor")
public class VendedorModel implements Serializable {
  private static final long serialVersionUID = 1;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_vendedor")
  private int idVendedor;

  @ManyToOne
  @JoinColumn(name = "idUsuario")
  private UsuarioModel usuario;
}
