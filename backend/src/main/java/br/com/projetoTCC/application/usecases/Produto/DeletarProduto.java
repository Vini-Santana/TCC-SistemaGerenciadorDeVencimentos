package br.com.projetoTCC.application.usecases.Produto;

import br.com.projetoTCC.application.gateways.RepositorioDeProduto;
import br.com.projetoTCC.domain.entities.Produto.Produto;

public class DeletarProduto {

    private final RepositorioDeProduto repositorioDeProduto;

    public DeletarProduto(RepositorioDeProduto repositorioDeProduto) {
        this.repositorioDeProduto = repositorioDeProduto;
    }

    public Produto deletarProduto(Long id, Produto produto){return repositorioDeProduto.deletarProduto(id, produto);}
}
