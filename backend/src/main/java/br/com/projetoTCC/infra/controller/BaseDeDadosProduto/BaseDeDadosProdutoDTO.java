package br.com.projetoTCC.infra.controller.BaseDeDadosProduto;

import jakarta.validation.constraints.NotBlank;

public record BaseDeDadosProdutoDTO(
        Long id,
        @NotBlank(message = "O nomeProduto não pode ser vazio ou nulo")
        String nomeProduto,
        @NotBlank(message = "O codigo não pode ser vazio ou nulo")
        String codigo,
        @NotBlank(message = "O codigo de Barras não pode ser vazio ou nulo")
        String codigoBarras) {
}
