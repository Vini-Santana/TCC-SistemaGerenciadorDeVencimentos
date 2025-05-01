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
//    Produto deletarProduto(Produto produto);
//    Produto alterarProduto(Produto produto);

}
