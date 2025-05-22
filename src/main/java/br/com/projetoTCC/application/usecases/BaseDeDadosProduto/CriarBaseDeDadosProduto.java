package br.com.projetoTCC.application.usecases.BaseDeDadosProduto;

import br.com.projetoTCC.application.gateways.RepositorioDeBaseDeDadosProduto;
import br.com.projetoTCC.domain.entities.BaseDeDadosProduto.BaseDeDadosProduto;

public class CriarBaseDeDadosProduto {

    private final RepositorioDeBaseDeDadosProduto repositorioDeBaseDeDadosProduto;

    public CriarBaseDeDadosProduto(RepositorioDeBaseDeDadosProduto repositorioDeBaseDeDadosProduto) {
        this.repositorioDeBaseDeDadosProduto = repositorioDeBaseDeDadosProduto;
    }


    public BaseDeDadosProduto criarBaseDeDadosProduto(BaseDeDadosProduto baseDeDadosProduto){
        return repositorioDeBaseDeDadosProduto.criarBaseDeDadosProduto(baseDeDadosProduto);
    }
}
