package br.com.alura.codechella.infra.controller.BaseDeDadosProduto;

import jakarta.validation.constraints.NotBlank;

public record BaseDeDadosProdutoDTO(
        @NotBlank(message = "O nomeProduto não pode ser vazio ou nulo")
        String nomeProduto,
        @NotBlank(message = "O codigo não pode ser vazio ou nulo")
        String codigo) {
}
