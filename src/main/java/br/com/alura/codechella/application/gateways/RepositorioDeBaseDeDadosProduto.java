package br.com.alura.codechella.application.gateways;

import br.com.alura.codechella.domain.entities.BaseDeDadosProduto.BaseDeDadosProduto;
import br.com.alura.codechella.domain.entities.Produto.Produto;

import java.util.List;

public interface RepositorioDeBaseDeDadosProduto {

    BaseDeDadosProduto criarBaseDeDadosProduto(BaseDeDadosProduto BaseDeDadosProduto);
    List<BaseDeDadosProduto> listarBaseDeDadosProduto();

//    Produto deletarProduto(Produto produto);
//    Produto alterarProduto(Produto produto);

}
