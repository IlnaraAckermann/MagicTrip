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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.magictrip.api.dtos.ImagemDestinoRecordDto;
import com.magictrip.api.models.DestinoModel;
import com.magictrip.api.models.ImagemDestinoModel;
import com.magictrip.api.repositories.DestinoRepository;
import com.magictrip.api.repositories.ImagemDestinoRepository;

import jakarta.validation.Valid;
import lombok.var;

@RestController
@RequestMapping("/imagens_destino")
public class ImagemDestinoController {

    @Autowired
    ImagemDestinoRepository imagemDestinoRepository;

    @Autowired
    DestinoRepository destinoRepository;

    @GetMapping()
    public ResponseEntity<List<ImagemDestinoModel>> getAllImagemByDestino() {
        List<ImagemDestinoModel> imagemList = imagemDestinoRepository.findAll();
        if (!imagemList.isEmpty()) {
            for (ImagemDestinoModel img : imagemList) {
                int id = img.getIdImagem();
                img.add(linkTo(methodOn(ImagemDestinoController.class).getImagemById(id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(imagemList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getImagemById(@PathVariable(value = "id") int id) {
        Optional<ImagemDestinoModel> imagemOptional = imagemDestinoRepository.findById(id);

        if (!imagemOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(imagemOptional.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Imagem " + id + " não encontrado.");

    }

    @GetMapping("/destino/{id}")
    public ResponseEntity<List<ImagemDestinoModel>> getImagemByDestino(@PathVariable(value = "id") int id) {
        List<ImagemDestinoModel> imgList = imagemDestinoRepository.findAllByDestinoId(id);
        if (!imgList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(imgList);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ArrayList<>());
    }

    @PostMapping()
    public ResponseEntity<?> saveDestinoImagem(@RequestBody @Valid ImagemDestinoRecordDto dto) {
        var imageModel = new ImagemDestinoModel();
        BeanUtils.copyProperties(dto, imageModel);

        Optional<DestinoModel> desOptional = destinoRepository.findById(dto.destino());

        if (desOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Erro: Destino " + dto.destino() + " não encontrado.");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(imagemDestinoRepository.save(imageModel));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateImage(@PathVariable(value = "id") int id,
            @RequestBody ImagemDestinoRecordDto dto) {

        Optional<ImagemDestinoModel> imageOptional = imagemDestinoRepository.findById(id);
        // valida se a imagem existe
        if (imageOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Imagem " + id + " não encontrado.");
        }

        var imageModel = imageOptional.get();

        if (dto.destino() != null) {
            // valida se o destino existe
            Optional<DestinoModel> desOptional = destinoRepository.findById(dto.destino());
            if (desOptional.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Destino " + dto.destino() + " não encontrado.");
            }
            var destino = desOptional.get();
            imageModel.setDestino(destino);
        }

        if (dto.imagemURL() != null) {
            imageModel.setImagemURL(dto.imagemURL());
        }
        if (dto.name() != null) {
            imageModel.setImagemURL(dto.name());
        }

        return ResponseEntity.status(HttpStatus.OK).body(imagemDestinoRepository.save(imageModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteImagem(@PathVariable(value = "id") int id) {
        Optional<ImagemDestinoModel> imageOptional = imagemDestinoRepository.findById(id);
        if (imageOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Imagem " + id + " não encontrado.");
        }
        imagemDestinoRepository.delete(imageOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Imagem deletada.");
    }
}
