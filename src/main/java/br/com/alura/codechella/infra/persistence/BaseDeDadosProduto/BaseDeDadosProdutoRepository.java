package br.com.alura.codechella.infra.persistence.BaseDeDadosProduto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseDeDadosProdutoRepository extends JpaRepository<BaseDeDadosProdutoEntity, Long> {
}
