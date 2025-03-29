package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.domain.entities.Produto.Produto;
import br.com.alura.codechella.infra.persistence.ProdutoEntity;

public class ProdutoEntityMapper {

    public ProdutoEntity toEntity (Produto produto){
        return new ProdutoEntity(produto.getNome(), produto.getCodigo(), produto.getCodInterno(), produto.getValidade(), produto.getLote());
    }

    public Produto toDamain(ProdutoEntity entity){
        return new Produto(entity.getNome(), entity.getCodigo(), entity.getCodInterno(), entity.getValidade(), entity.getLote());
    }
}
