package com.magictrip.api.models;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "imagem_destino")
public class ImagemDestinoModel extends RepresentationModel<ImagemDestinoModel> implements Serializable {
    private static final long serialVersionUID = 1;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_imagem")
    private int idImagem;

    @Column(name="name")
    private String name;

    @Lob
    @Column(name = "imagem_url", nullable = false, unique = true)
    private String imagemURL;

    @ManyToOne
    @JoinColumn(name = "id_destino", nullable = false)
    private DestinoModel destino;

}
