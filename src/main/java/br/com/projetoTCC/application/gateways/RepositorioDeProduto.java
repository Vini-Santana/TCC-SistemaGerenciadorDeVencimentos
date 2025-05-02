package br.com.projetoTCC.application.gateways;

import br.com.projetoTCC.domain.entities.Produto.Produto;

import java.time.LocalDate;
import java.util.List;

public interface RepositorioDeProduto {

    Produto criarProduto(Produto produto);
    List<Produto> listarTodosProduto();
    List<Produto> listarProdutoPorNome(String nomeProduto);
    List<Produto> listarProdutoPorCodigo(String codigo);
    List<Produto> listarProdutoPorQuantidade(Integer quantidade);
    List<Produto> listarProdutoPorValidade(LocalDate validade);
    Produto listarProdutoPorId(Long Id);
    Produto deletarProduto(Long id, Produto produto);
    Produto alterarProduto(Long id, Produto produto);

}
