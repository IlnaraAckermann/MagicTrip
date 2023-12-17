package com.magictrip.api.models;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "vendedor")
public class VendedorModel extends RepresentationModel<VendedorModel> implements Serializable {
  private static final long serialVersionUID = 1;
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id_vendedor")
  private int idVendedor;

  @Column(name = "telefone_comercial", nullable= false)
  private int telefone; //tipo int usa menos espaço que tipo string
  @Column(name = "email_comercial", nullable= false)
  private String email;

  @OneToOne
  @JoinColumn(name = "id_usuario")
  private UsuarioModel usuario;
}
