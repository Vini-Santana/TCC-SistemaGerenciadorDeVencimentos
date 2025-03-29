package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.RepositorioDeProduto;
import br.com.alura.codechella.domain.entities.Produto.FabricaDeProduto;
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
