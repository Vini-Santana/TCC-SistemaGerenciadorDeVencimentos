package br.com.alura.codechella.application.usecases.BaseDeDadosProduto;

import br.com.alura.codechella.application.gateways.RepositorioDeBaseDeDadosProduto;
import br.com.alura.codechella.domain.entities.BaseDeDadosProduto.BaseDeDadosProduto;

public class CriarBaseDeDadosProduto {

    private final RepositorioDeBaseDeDadosProduto repositorioDeBaseDeDadosProduto;

    public CriarBaseDeDadosProduto(RepositorioDeBaseDeDadosProduto repositorioDeBaseDeDadosProduto) {
        this.repositorioDeBaseDeDadosProduto = repositorioDeBaseDeDadosProduto;
    }


    public BaseDeDadosProduto criarBaseDeDadosProduto(BaseDeDadosProduto produto){
        return repositorioDeBaseDeDadosProduto.criarBaseDeDadosProduto(produto);
    }
}
