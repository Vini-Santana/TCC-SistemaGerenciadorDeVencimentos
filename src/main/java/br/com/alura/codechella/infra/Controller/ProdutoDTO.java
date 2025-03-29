package br.com.alura.codechella.infra.Controller;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ProdutoDTO(
        @NotBlank(message = "O nome não pode ser vazio ou nulo")
        String nome,

        @NotBlank(message = "O código não pode ser vazio ou nulo")
        String codigo,

        @NotBlank(message = "O código interno não pode ser vazio ou nulo")
        String codInterno,

        @NotNull(message = "A validade não pode ser nula")
        LocalDate validade,

        @NotBlank(message = "O lote não pode ser vazio ou nulo")
        String lote) {
}
