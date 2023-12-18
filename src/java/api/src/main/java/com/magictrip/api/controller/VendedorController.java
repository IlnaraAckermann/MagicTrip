package com.magictrip.api.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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

import com.magictrip.api.dtos.VendedorRecordDto;
import com.magictrip.api.models.UsuarioModel;
import com.magictrip.api.models.VendedorModel;
import com.magictrip.api.repositories.UsuarioRepository;
import com.magictrip.api.repositories.VendedorRepository;

import jakarta.validation.Valid;

@CrossOrigin(origins ="http://localhost:3000/")
@RestController
public class VendedorController {
    @Autowired
    VendedorRepository vendedorRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/vendedores")
    public ResponseEntity<List<VendedorModel>> getAllVendedores() {
        List<VendedorModel> vendedorList = vendedorRepository.findAll();
        if (!vendedorList.isEmpty()) {
            for (VendedorModel vendedor : vendedorList) {
                int id = vendedor.getIdVendedor();
                vendedor.add(linkTo(methodOn(VendedorController.class).getOneVendedor(id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(vendedorList);
    }

    @GetMapping("/vendedores/{id}")
    public ResponseEntity<Object> getOneVendedor(@PathVariable(value = "id") int id) {
        Optional<VendedorModel> vendedor0 = vendedorRepository.findById(id);
        if (vendedor0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vendedor " + id + " não encontrado.");
        }
        vendedor0.get().add(linkTo(methodOn(VendedorController.class).getAllVendedores()).withSelfRel());
        return ResponseEntity.status(HttpStatus.OK).body(vendedor0.get());
    }

    @PostMapping("/vendedores")
    public ResponseEntity<?> saveVendedor(@RequestBody @Valid VendedorRecordDto dto) {
        var vendedorModel = new VendedorModel();
        Optional<UsuarioModel> usuarioModel = usuarioRepository.findById(dto.usuario());
         if (usuarioModel.isEmpty()) {
                return ResponseEntity.status(HttpStatus.OK).body("Usuário" + dto.usuario() + "não encontrado");
            }
        BeanUtils.copyProperties(dto, vendedorModel);

            if (usuarioModel.isEmpty()) {
                return ResponseEntity.status(HttpStatus.OK).body("Usuário" + dto.usuario() + "não encontrado");
            }
            vendedorModel.setUsuario(usuarioModel.get());
        return ResponseEntity.status(HttpStatus.CREATED).body(vendedorRepository.save(vendedorModel));
    }

    @PutMapping("vendedores/{id}")
    public ResponseEntity<Object> updateVendedor(@PathVariable(value = "id") int id,
            @RequestBody VendedorRecordDto dto) {
        Optional<VendedorModel> vendedor0 = vendedorRepository.findById(id);
        if (vendedor0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vendedor " + id + " não encontrado.");
        }

        var vendedorModel = vendedor0.get();

        if (dto.email() != null) {
            vendedorModel.setEmail(dto.email());
        }
        if (dto.telefone() != null) {
            vendedorModel.setTelefone(dto.telefone());
        }
        if (dto.usuario() != null) {
            Optional<UsuarioModel> usuarioModel = usuarioRepository.findById(dto.usuario());
            if (usuarioModel.isEmpty()) {
                return ResponseEntity.status(HttpStatus.OK).body("Usuário" + id + "não encontrado");
            }
            vendedorModel.setUsuario(usuarioModel.get());
        }

        return ResponseEntity.status(HttpStatus.OK).body(vendedorRepository.save(vendedorModel));
    }

    @DeleteMapping("/vendedores/{id}")
    public ResponseEntity<Object> deleteVendedor(@PathVariable(value = "id") int id) {
        Optional<VendedorModel> vendedor0 = vendedorRepository.findById(id);
        if (vendedor0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vendedor " + id + " não encontrado.");
        }
        vendedorRepository.delete((vendedor0.get()));
        return ResponseEntity.status(HttpStatus.OK).body("Vendedor deletado.");
    }

}
