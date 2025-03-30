package br.com.alura.codechella.infra.gateways.Produto;

import br.com.alura.codechella.application.gateways.RepositorioDeProduto;
import br.com.alura.codechella.domain.entities.Produto.Produto;
import br.com.alura.codechella.infra.persistence.Produto.ProdutoEntity;
import br.com.alura.codechella.infra.persistence.Produto.ProdutoRepository;

import java.util.List;
import java.util.stream.Collectors;

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
        return mapper.toDomain(entity);
    }

    @Override
    public List<Produto> listarTodosProduto() {

        return repository.findAll().stream()
                .map(mapper::toDomain) //para cada usuário encontrado, faça algo (toDomain)
                .collect(Collectors.toList());
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
