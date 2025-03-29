package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.RepositorioDeProduto;
import br.com.alura.codechella.domain.entities.Produto.Produto;

import java.util.List;

public class ListarProduto {

    final RepositorioDeProduto repositorioDeProduto;

    public ListarProduto(RepositorioDeProduto repositorioDeProduto) {
        this.repositorioDeProduto = repositorioDeProduto;
    }

    public List<Produto> listarProdutos(){
        return repositorioDeProduto.listarTodosProduto();
    }
}
