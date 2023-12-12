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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.magictrip.api.dtos.VendedorRecordDto;
import com.magictrip.api.models.VendedorModel;
import com.magictrip.api.repositories.VendedorRepository;

import jakarta.validation.Valid;

@RestController
public class VendedorController {
    @Autowired
    VendedorRepository vendedorRepository;

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
    public ResponseEntity<VendedorModel> saveVendedor(@RequestBody @Valid VendedorRecordDto vendedorRecordDto) {
        var vendedorModel = new VendedorModel();
        BeanUtils.copyProperties(vendedorRecordDto, vendedorModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(vendedorRepository.save(vendedorModel));
    }

    @PostMapping("/vendedores/list")
    public ResponseEntity<List<VendedorModel>> saveVendedores(
            @RequestBody @Valid List<VendedorRecordDto> vendedorRecordDto) {
        List<VendedorModel> vendedorModels = new ArrayList<>();
        for (VendedorRecordDto vendedordDto : vendedorRecordDto) {
            var vendedorModel = new VendedorModel();
            BeanUtils.copyProperties(vendedordDto, vendedorModel);
            vendedorModels.add(vendedorModel);
        }
        List<VendedorModel> savedVendedores = vendedorRepository.saveAll(vendedorModels);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedVendedores);
    }

    @PutMapping("vendedores/{id}")
    public ResponseEntity<Object> updateVendedor(@PathVariable(value = "id") int id,
            @RequestBody VendedorRecordDto vendedorRecordDto) {
        Optional<VendedorModel> vendedor0 = vendedorRepository.findById(id);
        if (vendedor0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vendedor " + id + " não encontrado.");
        }

        var vendedorModel = vendedor0.get();

        
        BeanUtils.copyProperties(vendedorRecordDto, vendedorModel);

        return ResponseEntity.status(HttpStatus.OK).body(vendedorRepository.save(vendedorModel));
    }

       @DeleteMapping("/vendedores/{id}")
    public ResponseEntity<Object> deleteVendedor(@PathVariable(value = "id") int id) {
        Optional<VendedorModel> vendedor0 = vendedorRepository.findById(id);
        if (vendedor0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vendedor " + id +" não encontrado.");
        }
        vendedorRepository.delete((vendedor0.get()));
        return ResponseEntity.status(HttpStatus.OK).body("Vendedor deletado.");
    }


}
