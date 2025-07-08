package br.com.projetoTCC.infra.gateways.BaseDeDadosProduto;

import br.com.projetoTCC.domain.entities.BaseDeDadosProduto.BaseDeDadosProduto;
import br.com.projetoTCC.infra.persistence.BaseDeDadosProduto.BaseDeDadosProdutoEntity;

public class BaseDeDadosProdutoEntityMapper {

    public BaseDeDadosProduto toDomain(BaseDeDadosProdutoEntity entity){
        return new BaseDeDadosProduto(entity.getNomeProduto(), entity.getCodigo(), entity.getCodigoBarras());
    }

    public BaseDeDadosProdutoEntity toEntity(BaseDeDadosProduto domain){
        return new BaseDeDadosProdutoEntity(domain.getNomeProduto(), domain.getCodigo(), domain.getCodigoBarras());
    }
}
