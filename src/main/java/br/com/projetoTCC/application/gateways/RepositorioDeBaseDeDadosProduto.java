package br.com.projetoTCC.application.gateways;

import br.com.projetoTCC.domain.entities.BaseDeDadosProduto.BaseDeDadosProduto;

import java.util.List;

public interface RepositorioDeBaseDeDadosProduto {

    BaseDeDadosProduto criarBaseDeDadosProduto(BaseDeDadosProduto BaseDeDadosProduto);
    List<BaseDeDadosProduto> listarBaseDeDadosProduto();

//    Produto deletarProduto(Produto produto);
//    Produto alterarProduto(Produto produto);

}
