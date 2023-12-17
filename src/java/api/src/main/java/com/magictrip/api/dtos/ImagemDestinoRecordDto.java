package com.magictrip.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ImagemDestinoRecordDto(
        @NotBlank String name,
        @NotBlank String imagemURL,
        @NotNull Integer destino) {

}
