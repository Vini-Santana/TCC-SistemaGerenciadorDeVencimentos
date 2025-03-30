package br.com.alura.codechella.infra.gateways.BaseDeDadosProduto;

import br.com.alura.codechella.domain.entities.BaseDeDadosProduto.BaseDeDadosProduto;
import br.com.alura.codechella.infra.controller.BaseDeDadosProduto.BaseDeDadosProdutoDTO;
import br.com.alura.codechella.infra.persistence.BaseDeDadosProduto.BaseDeDadosProdutoEntity;

public class BaseDeDadosProdutoEntityMapper {

    public BaseDeDadosProduto toDomain(BaseDeDadosProdutoEntity entity){
        return new BaseDeDadosProduto(entity.getNomeProduto(), entity.getCodigo());
    }

    public BaseDeDadosProdutoEntity toEntity(BaseDeDadosProduto domain){
        return new BaseDeDadosProdutoEntity(domain.getNomeProduto(), domain.getCodigo());
    }
}
