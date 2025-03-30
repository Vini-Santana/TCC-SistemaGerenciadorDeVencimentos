package br.com.alura.codechella.application.usecases.BaseDeDadosProduto;

import br.com.alura.codechella.application.gateways.RepositorioDeBaseDeDadosProduto;
import br.com.alura.codechella.domain.entities.BaseDeDadosProduto.BaseDeDadosProduto;

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
