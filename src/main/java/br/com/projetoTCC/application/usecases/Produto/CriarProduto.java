package br.com.projetoTCC.application.usecases.Produto;

import br.com.projetoTCC.application.gateways.RepositorioDeProduto;
import br.com.projetoTCC.domain.entities.Produto.Produto;

public class CriarProduto {
    private final RepositorioDeProduto repositorio;

    public CriarProduto(RepositorioDeProduto repositorio) {
        this.repositorio = repositorio;
    }

    public Produto criarproduto(Produto produto){
        return repositorio.criarProduto(produto);
    }
}
