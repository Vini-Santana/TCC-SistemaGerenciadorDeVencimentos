package br.com.projetoTCC.infra.controller.Produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ProdutoDTO(
        @NotBlank(message = "O nome não pode ser vazio ou nulo")
        String nomeProduto,

        @NotBlank(message = "O código não pode ser vazio ou nulo")
        String codigo,

        @NotNull(message = "A quantidade não pode ser vazia ou nula")
        Integer quantidade,

        @NotNull(message = "A validade não pode ser nula")
        LocalDate validade,

        String observacoes)
{}
