package br.com.projetoTCC.domain.entities.Produto;

import java.time.LocalDate;

public class FabricaDeProduto {

    public Produto criaProduto(String nomeProduto, String codigo, Integer quantidade, LocalDate validade, String observacoes, LocalDate dataUltimaModificacao){
        Produto produto = new Produto(nomeProduto, codigo, quantidade,validade, observacoes, dataUltimaModificacao);
        return produto;
    }

}
