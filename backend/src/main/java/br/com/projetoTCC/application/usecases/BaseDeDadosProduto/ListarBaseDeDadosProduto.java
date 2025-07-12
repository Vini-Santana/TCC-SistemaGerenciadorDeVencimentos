package br.com.projetoTCC.application.usecases.BaseDeDadosProduto;

import br.com.projetoTCC.application.gateways.RepositorioDeBaseDeDadosProduto;
import br.com.projetoTCC.domain.entities.BaseDeDadosProduto.BaseDeDadosProduto;


import java.util.List;

public class ListarBaseDeDadosProduto {

    private final RepositorioDeBaseDeDadosProduto repositorioDeBaseDeDadosProduto;

    public ListarBaseDeDadosProduto(RepositorioDeBaseDeDadosProduto repositorioDeBaseDeDadosProduto) {
        this.repositorioDeBaseDeDadosProduto = repositorioDeBaseDeDadosProduto;
    }

    public List<BaseDeDadosProduto> listarTodosBaseDeDadosProduto(){
        return repositorioDeBaseDeDadosProduto.listarTodosBaseDeDadosProduto();
    }

    public List<BaseDeDadosProduto> listarBaseDeDadosProdutoPorNome(String nomeProduto){
        return repositorioDeBaseDeDadosProduto.listarBaseDeDadosProdutoPorNome(nomeProduto);
    }

    public List<BaseDeDadosProduto> listarBaseDeDadosProdutoPorCodigo(String codigo){
        return repositorioDeBaseDeDadosProduto.listarBaseDeDadosProdutoPorCodigo(codigo);
    }

    public BaseDeDadosProduto listarBaseDeDadosProdutoPorId(Long id){
        return repositorioDeBaseDeDadosProduto.listarBaseDeDadosProdutoPorId(id);
    }

    public List<BaseDeDadosProduto> listarBaseDeDadosProdutoPorCodigoBarras(String codigoBarras){
        return repositorioDeBaseDeDadosProduto.listarBaseDeDadosProdutoPorCodigoBarras(codigoBarras);
    }
}
