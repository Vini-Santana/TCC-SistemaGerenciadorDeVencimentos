package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.application.gateways.RepositorioDeProduto;
import br.com.alura.codechella.domain.entities.Produto.Produto;
import br.com.alura.codechella.infra.persistence.ProdutoEntity;
import br.com.alura.codechella.infra.persistence.ProdutoRepository;

import java.util.List;

public class RepositorioDeProdutoJpa implements RepositorioDeProduto {

    private final ProdutoRepository repository;
    private final ProdutoEntityMapper mapper;

    public RepositorioDeProdutoJpa(ProdutoRepository repository, ProdutoEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Produto criarProduto(Produto produto) {
        ProdutoEntity entity = mapper.toEntity(produto);
        repository.save(entity);
        return mapper.toDamain(entity);
    }

    @Override
    public List<Produto> listarTodosProduto() {
        return List.of();
    }

//    @Override
//    public Produto deletarProduto(Produto produto) {
//        return repository.delete(produto);
//    }
//
//    @Override
//    public Produto alterarProduto(Produto produto) {
//        return repository.u;
//        }
}
