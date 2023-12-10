package com.magictrip.api.dtos;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

/**
 * UsuarioRecordDto
 */
public record UsuarioRecordDto(
        @Size(min = 11, max = 11) @NotBlank String cpf,
        @NotBlank String cidade,
        @NotBlank @Size(min = 2, max = 2) String estado,
        @NotBlank String endereco,
        @NotBlank String nome,
        @NotBlank @Email String email,
        @NotBlank String senha,
        @NotNull @Past LocalDate dataNascimento) {
}

