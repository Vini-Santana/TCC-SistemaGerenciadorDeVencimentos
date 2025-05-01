package br.com.projetoTCC.application.usecases.Produto;

import br.com.projetoTCC.application.gateways.RepositorioDeProduto;
import br.com.projetoTCC.domain.entities.Produto.Produto;

import java.time.LocalDate;
import java.util.List;

public class ListarProduto {

    final RepositorioDeProduto repositorioDeProduto;

    public ListarProduto(RepositorioDeProduto repositorioDeProduto) {
        this.repositorioDeProduto = repositorioDeProduto;
    }

    public List<Produto> listarTodosProdutos(){
        return repositorioDeProduto.listarTodosProduto();
    }

    public List<Produto> listarProdutoPorNome(String nome){
        return repositorioDeProduto.listarProdutoPorNome(nome);
    }

    public List<Produto> listarProdutoPorCodigo(String codigo){
        return repositorioDeProduto.listarProdutoPorCodigo(codigo);
    }

    public List<Produto> listarProdutoPorQuantidade(Integer quantidade){
        return repositorioDeProduto.listarProdutoPorQuantidade(quantidade);
    }

    public List<Produto> listarProdutoPorValidade(LocalDate validade){
        return repositorioDeProduto.listarProdutoPorValidade(validade);
    }
}
