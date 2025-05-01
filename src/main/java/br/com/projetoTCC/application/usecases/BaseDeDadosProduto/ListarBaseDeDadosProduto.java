package br.com.projetoTCC.application.usecases.BaseDeDadosProduto;

import br.com.projetoTCC.application.gateways.RepositorioDeBaseDeDadosProduto;
import br.com.projetoTCC.domain.entities.BaseDeDadosProduto.BaseDeDadosProduto;


import java.util.List;

public class ListarBaseDeDadosProduto {

    private final RepositorioDeBaseDeDadosProduto repositorioDeBaseDeDadosProduto;

    public ListarBaseDeDadosProduto(RepositorioDeBaseDeDadosProduto repositorioDeBaseDeDadosProduto) {
        this.repositorioDeBaseDeDadosProduto = repositorioDeBaseDeDadosProduto;
    }

    public List<BaseDeDadosProduto> listarBaseDeDadosProduto(){
        return repositorioDeBaseDeDadosProduto.listarBaseDeDadosProduto();
    }
}
