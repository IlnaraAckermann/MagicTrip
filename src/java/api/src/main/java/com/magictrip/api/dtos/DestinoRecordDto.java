package com.magictrip.api.dtos;

import jakarta.validation.constraints.NotBlank;

public record DestinoRecordDto(
    @NotBlank String nome, 
    String descricao) {

}
