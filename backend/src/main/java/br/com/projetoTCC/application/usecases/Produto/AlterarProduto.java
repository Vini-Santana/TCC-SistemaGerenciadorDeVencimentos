package br.com.projetoTCC.application.usecases.Produto;

import br.com.projetoTCC.application.gateways.RepositorioDeProduto;
import br.com.projetoTCC.domain.entities.Produto.Produto;

public class AlterarProduto {

    private final RepositorioDeProduto repositorioDeProduto;

    public AlterarProduto(RepositorioDeProduto repositorioDeProduto) {
        this.repositorioDeProduto = repositorioDeProduto;
    }

    public Produto alteraProduto(Long idProduto, Produto produto){return repositorioDeProduto.alterarProduto(idProduto, produto);}
}
