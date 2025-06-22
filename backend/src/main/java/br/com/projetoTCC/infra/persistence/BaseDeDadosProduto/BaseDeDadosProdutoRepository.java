package br.com.projetoTCC.infra.persistence.BaseDeDadosProduto;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BaseDeDadosProdutoRepository extends JpaRepository<BaseDeDadosProdutoEntity, Long> {

    List<BaseDeDadosProdutoEntity> findBynomeProdutoStartingWithIgnoreCase(String nomeProduto);
    List<BaseDeDadosProdutoEntity> findByCodigoStartingWithIgnoreCase(String codigo);
}
