package br.com.projetoTCC.infra.gateways.Produto;

import br.com.projetoTCC.application.gateways.RepositorioDeProduto;
import br.com.projetoTCC.domain.entities.Produto.Produto;
import br.com.projetoTCC.domain.exceptions.ProdutoNotFoundExceptionId;
import br.com.projetoTCC.infra.persistence.Produto.ProdutoEntity;
import br.com.projetoTCC.infra.persistence.Produto.ProdutoRepository;
import java.time.LocalDate;
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


//    public List<Produto> validaProdutoExistente(Produto produto) {
//
//        repository.findByNomeProdutoStartingWithIgnoreCase(nomeProduto).stream()
//                .map(mapper::toDomain) //para cada usuário encontrado, faça algo (toDomain)
//                .collect(Collectors.toList());
//    }

    @Override
    public Produto alterarProduto(Long id, Produto produto) {

        ProdutoEntity entity = new ProdutoEntity(id, produto.getNomeProduto(), produto.getCodigo(), produto.getQuantidade(), produto.getValidade(), produto.getObservacoes(), produto.getLote(), produto.getUltimaModificacao());
        repository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public List<Produto> listarTodosProduto() {
        return repository.findAll().stream()
                .map(mapper::toDomain) //para cada usuário encontrado, faça algo (toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Produto> listarProdutoPorNome(String nomeProduto) {
        return repository.findByNomeProdutoStartingWithIgnoreCase(nomeProduto).stream()
                .map(mapper::toDomain) //para cada usuário encontrado, faça algo (toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Produto> listarProdutoPorCodigo(String codigo) {
        return repository.findByCodigoStartingWithIgnoreCase(codigo).stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Produto> listarProdutoPorQuantidade(Integer quantidade) {
        return repository.findByQuantidadeLessThanEqual(quantidade).stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Produto> listarProdutoPorValidade(LocalDate validade) {
        return repository.findByValidadeLessThanEqual(validade).stream()
                .map(mapper::toDomain) //para cada usuário encontrado, faça algo (toDomain)
                .collect(Collectors.toList());
    }

    public Produto listarProdutoPorId(Long id) {
        ProdutoEntity entity = repository.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundExceptionId(id));
        return mapper.toDomain(entity);
    }

    @Override
    public Produto deletarProduto(Long id, Produto produto) {
        repository.deleteById(id);
        return produto;
    }
}