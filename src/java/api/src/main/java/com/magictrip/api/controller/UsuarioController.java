package com.magictrip.api.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.magictrip.api.dtos.UsuarioRecordDto;
import com.magictrip.api.models.UsuarioModel;
import com.magictrip.api.repositories.UsuarioRepository;

import jakarta.validation.Valid;

@CrossOrigin(origins ="http://localhost:3000/")
@RestController
public class UsuarioController {
    /** Injeta o repositorio */
    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    public ResponseEntity<List<UsuarioModel>> getAllUsuarios() {
        List<UsuarioModel> usuarioList = usuarioRepository.findAll();
        if (!usuarioList.isEmpty()) {
            for (UsuarioModel usuario : usuarioList) {
                Long id = usuario.getIdUsuario();
                usuario.add(linkTo(methodOn(UsuarioController.class).getOneUsuario(id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(usuarioList);
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Object> getOneUsuario(@PathVariable(value = "id") Long idUsuario) {
        Optional<UsuarioModel> usuario0 = usuarioRepository.findById(idUsuario);
        if (usuario0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
        }
        usuario0.get().add(linkTo(methodOn(UsuarioController.class).getAllUsuarios()).withSelfRel());
        return ResponseEntity.status(HttpStatus.OK).body(usuario0.get());
    }

    /* Métopdo de post, salva um novo usuario */
    @PostMapping("/usuarios")
    public ResponseEntity<UsuarioModel> saveUsuario(@RequestBody @Valid UsuarioRecordDto usuarioRecordDto) {
        var usuarioModel = new UsuarioModel();
        BeanUtils.copyProperties(usuarioRecordDto, usuarioModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuarioModel));
    }

    // nao é possivel fazer a sobrecarga, por isso fiz um novo endpoint
    /* Métopdo de post, salva vários usuarios */
    @PostMapping("/usuarios/list")
    public ResponseEntity<List<UsuarioModel>> saveUsuario(
            @RequestBody @Valid List<UsuarioRecordDto> usuariosRecordDto) {
        List<UsuarioModel> usuariosModel = new ArrayList<>();

        for (UsuarioRecordDto usuarioRecordDto : usuariosRecordDto) {
            UsuarioModel usuarioModel = new UsuarioModel();
            BeanUtils.copyProperties(usuarioRecordDto, usuarioModel);
            usuariosModel.add(usuarioModel);
        }

        List<UsuarioModel> savedUsuarios = usuarioRepository.saveAll(usuariosModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUsuarios);
    }

    @PutMapping("/usuarios/{id}")
    public ResponseEntity<Object> updateUsuario(@PathVariable(value = "id") long idUsuario,
            @RequestBody UsuarioRecordDto usuarioRecordDto) {
        Optional<UsuarioModel> usuario0 = usuarioRepository.findById(idUsuario);
        if (usuario0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário " + idUsuario + " não encontrado.");
        }
        var usuarioModel = usuario0.get();

        if (usuarioRecordDto.cidade() != null) {
            usuarioModel.setCidade(usuarioRecordDto.cidade());
        }
        if (usuarioRecordDto.cpf() != null) {
            usuarioModel.setCpf(usuarioRecordDto.cpf());
        }
        if (usuarioRecordDto.email() != null) {
            usuarioModel.setEmail(usuarioRecordDto.email());
        }
        if (usuarioRecordDto.endereco() != null) {
            usuarioModel.setEndereco(usuarioRecordDto.endereco());
        }
        if (usuarioRecordDto.estado() != null)
            usuarioModel.setEstado(usuarioRecordDto.estado());

        if (usuarioRecordDto.nome() != null) {
            usuarioModel.setNome(usuarioRecordDto.nome());
        }
        if (usuarioRecordDto.senha() != null) {
            usuarioModel.setSenha(usuarioRecordDto.senha());
        }

        return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.save(usuarioModel));
    }

    @DeleteMapping("/usuarios/{id}")
    public ResponseEntity<Object> deleteUsuario(@PathVariable(value = "id") Long idUsuario) {
        Optional<UsuarioModel> usuario0 = usuarioRepository.findById(idUsuario);
        if (usuario0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado.");
        }
        usuarioRepository.delete(usuario0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Usuário deletado.");
    }
};
