package br.com.alura.codechella.application.gateways;

import br.com.alura.codechella.domain.entities.Produto.Produto;

import java.util.List;

public interface RepositorioDeProduto {

    Produto criarProduto(Produto produto);
    List<Produto> listarTodosProduto();
//    Produto deletarProduto(Produto produto);
//    Produto alterarProduto(Produto produto);

}
