package br.com.projetoTCC.application.usecases.BaseDeDadosProduto;

import br.com.projetoTCC.application.gateways.RepositorioDeBaseDeDadosProduto;
import br.com.projetoTCC.domain.entities.BaseDeDadosProduto.BaseDeDadosProduto;
import br.com.projetoTCC.domain.entities.Produto.Produto;

public class AlterarBaseDeDadosProduto {

    private final RepositorioDeBaseDeDadosProduto repositorioDeProduto;

    public AlterarBaseDeDadosProduto(RepositorioDeBaseDeDadosProduto repositorioDeBaseDeDadosProduto) {
        this.repositorioDeProduto = repositorioDeBaseDeDadosProduto;
    }

    public BaseDeDadosProduto alteraBaseDeDadosProduto(Long idProduto, BaseDeDadosProduto produto){return repositorioDeProduto.alterarBaseDeDadosProduto(idProduto, produto);}
}
