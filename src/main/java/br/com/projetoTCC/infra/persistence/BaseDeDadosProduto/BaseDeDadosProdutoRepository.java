package br.com.projetoTCC.infra.persistence.BaseDeDadosProduto;

import br.com.projetoTCC.infra.persistence.Produto.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BaseDeDadosProdutoRepository extends JpaRepository<BaseDeDadosProdutoEntity, Long> {

    List<BaseDeDadosProdutoEntity> findByNomeBaseDeDadosProdutoStartingWithIgnoreCase(String nomeProduto);
    List<BaseDeDadosProdutoEntity> findByCodigoStartingWithIgnoreCase(String codigo);
}
