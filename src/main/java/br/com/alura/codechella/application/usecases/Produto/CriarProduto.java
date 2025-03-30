package br.com.alura.codechella.application.usecases.Produto;

import br.com.alura.codechella.application.gateways.RepositorioDeProduto;
import br.com.alura.codechella.domain.entities.Produto.Produto;

public class CriarProduto {
    private final RepositorioDeProduto repositorio;

    public CriarProduto(RepositorioDeProduto repositorio) {
        this.repositorio = repositorio;
    }

    public Produto criarproduto(Produto produto){
        return repositorio.criarProduto(produto);
    }
}
