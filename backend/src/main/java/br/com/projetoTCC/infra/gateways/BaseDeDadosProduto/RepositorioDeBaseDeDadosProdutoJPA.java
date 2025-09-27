package br.com.projetoTCC.infra.gateways.BaseDeDadosProduto;

import br.com.projetoTCC.application.gateways.RepositorioDeBaseDeDadosProduto;
import br.com.projetoTCC.domain.entities.BaseDeDadosProduto.BaseDeDadosProduto;
import br.com.projetoTCC.domain.exceptions.BaseDeDadosProdutoNotFoundExceptionId;
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
    public BaseDeDadosProduto criarBaseDeDadosProduto(BaseDeDadosProduto baseDeDadosProduto) {
        BaseDeDadosProdutoEntity entity = mapper.toEntity(baseDeDadosProduto);
        repository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public BaseDeDadosProduto deletarBaseDeDadosProduto(Long id, BaseDeDadosProduto baseDeDadosProduto) {
        repository.deleteById(id);
        return baseDeDadosProduto;
    }

    @Override
    public BaseDeDadosProduto alterarBaseDeDadosProduto(Long id, BaseDeDadosProduto produto) {
        BaseDeDadosProdutoEntity entity = new BaseDeDadosProdutoEntity(id, produto.getNomeProduto(), produto.getCodigo(), produto.getCodigoBarras());
        repository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public List<BaseDeDadosProduto> listarTodosBaseDeDadosProduto() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<BaseDeDadosProduto> listarBaseDeDadosProdutoPorNome(String nomeProduto) {
        return repository.findBynomeProduto(nomeProduto).stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<BaseDeDadosProduto> listarBaseDeDadosProdutoPorCodigo(String codigo) {
        return repository.findByCodigo(codigo).stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<BaseDeDadosProduto> listarBaseDeDadosProdutoPorCodigoBarras(String codigo) {
        return repository.findByCodigoBarras(codigo).stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public BaseDeDadosProduto listarBaseDeDadosProdutoPorId(Long id) {
        BaseDeDadosProdutoEntity entity = repository.findById(id)
                .orElseThrow(() -> new BaseDeDadosProdutoNotFoundExceptionId(id));
        return mapper.toDomain(entity);
    }
}
