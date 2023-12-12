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

import com.magictrip.api.dtos.DestinoRecordDto;
import com.magictrip.api.models.DestinoModel;
import com.magictrip.api.repositories.DestinoRepository;

import jakarta.validation.Valid;
import lombok.var;

/**
 * DestinoController
 */
@RestController
public class DestinoController {

    @Autowired
    DestinoRepository destinoRepository;

    @GetMapping("/destinos")
    public ResponseEntity<List<DestinoModel>> getAllDestinos() {
        List<DestinoModel> destinoList = destinoRepository.findAll();
        if (!destinoList.isEmpty()) {
            for (DestinoModel destino : destinoList) {
                int id = destino.getIdDestino();
                destino.add(linkTo(methodOn(DestinoController.class).getOneDestino(id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(destinoList);
    }

    @GetMapping("/destinos/{id}")
    public ResponseEntity<Object> getOneDestino(@PathVariable(value = "id") int idDestino) {
        Optional<DestinoModel> destino0 = destinoRepository.findById(idDestino);
        if (destino0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Destino " + idDestino + " não encontrado.");
        }
        destino0.get().add(linkTo(methodOn(DestinoController.class).getAllDestinos()).withSelfRel());
        return ResponseEntity.status(HttpStatus.OK).body(destino0.get());
    }

    @PostMapping("/destinos")
    public ResponseEntity<DestinoModel> saveDestino(@RequestBody @Valid DestinoRecordDto destinoRecordDto) {
        var destinoModel = new DestinoModel();
        BeanUtils.copyProperties(destinoRecordDto, destinoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(destinoRepository.save(destinoModel));
    }
    
@PostMapping("/destinos/list")
    public ResponseEntity<List<DestinoModel>> saveDestinos(@RequestBody @Valid List<DestinoRecordDto> destinoRecordDto) {
        List<DestinoModel> destinosModel = new ArrayList<>();
        for (DestinoRecordDto destinoDto : destinoRecordDto){
            var destinoModel = new DestinoModel();
            BeanUtils.copyProperties(destinoDto,destinoModel);
            destinosModel.add(destinoModel);
        }
        List<DestinoModel> savedDestinos = destinoRepository.saveAll(destinosModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDestinos);
    }

    @PutMapping("destinos/{id}")
    public ResponseEntity<Object> updateDestino(@PathVariable (value="id") int idDestino, @RequestBody DestinoRecordDto destinoRecordDto) {
        Optional<DestinoModel> destino0 = destinoRepository.findById(idDestino);
        if (destino0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Destino " + idDestino + " não encontrado."); 
        }

        var destinoModel = destino0.get();

        if(destinoRecordDto.descricao() !=null){
            destinoModel.setDescricao(destinoRecordDto.descricao());
        }
        
        if(destinoRecordDto.nome() !=null){
            destinoModel.setNome(destinoRecordDto.nome());
        }
        return ResponseEntity.status(HttpStatus.OK).body(destinoRepository.save(destinoModel));
    }

     @DeleteMapping("/destinos/{id}")
    public ResponseEntity<Object> deleteDestino(@PathVariable(value = "id") int idDestino) {
        Optional<DestinoModel> destino0 = destinoRepository.findById(idDestino);
        if (destino0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Destino " + idDestino +" não encontrado.");
        }
        destinoRepository.delete((destino0.get()));
        return ResponseEntity.status(HttpStatus.OK).body("Destino deletado.");
    }
}