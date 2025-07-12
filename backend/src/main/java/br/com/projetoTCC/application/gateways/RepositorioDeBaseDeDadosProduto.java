package br.com.projetoTCC.application.gateways;

import br.com.projetoTCC.domain.entities.BaseDeDadosProduto.BaseDeDadosProduto;
import br.com.projetoTCC.domain.entities.Produto.Produto;

import java.util.List;

public interface RepositorioDeBaseDeDadosProduto {

    BaseDeDadosProduto criarBaseDeDadosProduto(BaseDeDadosProduto baseDeDadosProduto);
    List<BaseDeDadosProduto> listarTodosBaseDeDadosProduto();
    List<BaseDeDadosProduto> listarBaseDeDadosProdutoPorNome(String nomeProduto);
    List<BaseDeDadosProduto> listarBaseDeDadosProdutoPorCodigo(String codigo);
    List<BaseDeDadosProduto> listarBaseDeDadosProdutoPorCodigoBarras(String codigoBarras);
    BaseDeDadosProduto listarBaseDeDadosProdutoPorId(Long Id);
    BaseDeDadosProduto deletarBaseDeDadosProduto(Long id, BaseDeDadosProduto produto);
    BaseDeDadosProduto alterarBaseDeDadosProduto(Long id, BaseDeDadosProduto produto);

}
