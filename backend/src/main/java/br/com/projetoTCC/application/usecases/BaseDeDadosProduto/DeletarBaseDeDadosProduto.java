package br.com.projetoTCC.application.usecases.BaseDeDadosProduto;

import br.com.projetoTCC.application.gateways.RepositorioDeBaseDeDadosProduto;
import br.com.projetoTCC.application.gateways.RepositorioDeProduto;
import br.com.projetoTCC.domain.entities.BaseDeDadosProduto.BaseDeDadosProduto;
import br.com.projetoTCC.domain.entities.Produto.Produto;

public class DeletarBaseDeDadosProduto {

    private final RepositorioDeBaseDeDadosProduto repositorioDeBaseDeDadosProduto;

    public DeletarBaseDeDadosProduto(RepositorioDeBaseDeDadosProduto repositorioDeBaseDeDadosProduto) {
        this.repositorioDeBaseDeDadosProduto = repositorioDeBaseDeDadosProduto;
    }

    public BaseDeDadosProduto deletarBaseDeDadosProduto(Long id, BaseDeDadosProduto produto){return repositorioDeBaseDeDadosProduto.deletarBaseDeDadosProduto(id, produto);}
}
