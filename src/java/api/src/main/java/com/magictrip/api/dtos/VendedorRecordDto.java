package com.magictrip.api.dtos;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VendedorRecordDto(@NotNull Long usuario,
    @NotNull Integer telefone,
    @NotBlank String email
) {
    
}
