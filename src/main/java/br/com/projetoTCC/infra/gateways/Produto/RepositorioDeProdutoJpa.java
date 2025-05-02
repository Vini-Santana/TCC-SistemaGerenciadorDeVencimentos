package br.com.projetoTCC.infra.gateways.Produto;

import br.com.projetoTCC.application.gateways.RepositorioDeProduto;
import br.com.projetoTCC.domain.entities.Produto.Produto;
import br.com.projetoTCC.domain.exceptions.ProdutoNotFoundException;
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

    @Override
    public Produto alterarProduto(Long id, Produto produto) {

        ProdutoEntity entity = new ProdutoEntity(id, produto.getNomeProduto(), produto.getCodigo(), produto.getQuantidade(), produto.getValidade(), produto.getObservacoes());
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
                .orElseThrow(() -> new ProdutoNotFoundException(id));
        return mapper.toDomain(entity);
    }

    @Override
    public Produto deletarProduto(Long id, Produto produto) {
        repository.deleteById(id);
        return produto;
    }

//    @Override
//    public List<Produto> listarProdutoPorNome(String nome) {
//        List<Produto> produtos = new ArrayList<>();
//        String sql = "SELECT * FROM produtos WHERE nome LIKE ?";
//
//        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
//            stmt.setString(1, "%" + nome + "%"); // LIKE '%nome%'
//            ResultSet rs = stmt.executeQuery();
//
//            while (rs.next()) {
//                produtos.add(new Produto(
////                        rs.getLong("id"),
//                        rs.getString("nomeProduto"),
//                        rs.getString("codigo"),
//                        rs.getInt("quantidade"),
//                        rs.getDate("validade").toLocalDate(),
//                        rs.getString("observacoes")
//
//                ));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return produtos;
//    }


//    @Query("SELECT P.* FROM PRODUTO P WHERE P.NOMEPRODUTO LIKE :NOMEPRODUTO")
//    @Override
//    public List<Produto> listarProdutoPorNome(@Param("NOMEPRODUTO")@RequestParam String nome) {
//        return repository.
//                findAll().stream()
//                .map(mapper::toDomain) //para cada usuário encontrado, faça algo (toDomain)
//                .collect(Collectors.toList());;
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
