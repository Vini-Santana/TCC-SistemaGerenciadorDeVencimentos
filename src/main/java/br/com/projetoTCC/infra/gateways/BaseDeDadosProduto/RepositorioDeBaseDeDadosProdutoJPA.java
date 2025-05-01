package br.com.projetoTCC.infra.gateways.BaseDeDadosProduto;

import br.com.projetoTCC.application.gateways.RepositorioDeBaseDeDadosProduto;
import br.com.projetoTCC.domain.entities.BaseDeDadosProduto.BaseDeDadosProduto;
import br.com.projetoTCC.infra.persistence.BaseDeDadosProduto.BaseDeDadosProdutoEntity;
import br.com.projetoTCC.infra.persistence.BaseDeDadosProduto.BaseDeDadosProdutoRepository;

import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeBaseDeDadosProdutoJPA implements RepositorioDeBaseDeDadosProduto {

    private final BaseDeDadosProdutoRepository repository ;
    private final BaseDeDadosProdutoEntityMapper mapper;

    public RepositorioDeBaseDeDadosProdutoJPA(BaseDeDadosProdutoRepository repository, BaseDeDadosProdutoEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public BaseDeDadosProduto criarBaseDeDadosProduto(BaseDeDadosProduto BaseDeDadosProduto) {
        BaseDeDadosProdutoEntity entity = mapper.toEntity(BaseDeDadosProduto);
        repository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public List<BaseDeDadosProduto> listarBaseDeDadosProduto() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}
