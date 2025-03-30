package br.com.alura.codechella.infra.gateways.Produto;

import br.com.alura.codechella.domain.entities.Produto.Produto;
import br.com.alura.codechella.infra.persistence.Produto.ProdutoEntity;

public class ProdutoEntityMapper {

    public ProdutoEntity toEntity (Produto produto){
        return new ProdutoEntity(produto.getNomeProduto(), produto.getCodigo(), produto.getQuantidade(), produto.getValidade(), produto.getObservacoes());
    }

    public Produto toDomain(ProdutoEntity entity){
        return new Produto(entity.getNomeProduto(), entity.getCodigo(), entity.getQuantidade(), entity.getValidade(), entity.getNomeProduto());
    }
}
