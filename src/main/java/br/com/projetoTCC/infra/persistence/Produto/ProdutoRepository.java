package br.com.projetoTCC.infra.persistence.Produto;

import br.com.projetoTCC.domain.entities.Produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

    List<ProdutoEntity> findByNomeProdutoStartingWithIgnoreCase(String nomeProduto);
    List<ProdutoEntity> findByCodigoStartingWithIgnoreCase(String codigo);
    List<ProdutoEntity> findByValidadeLessThanEqual(LocalDate validade);
    List<ProdutoEntity> findByQuantidadeLessThanEqual(Integer quantidade);

//    ProdutoEntity findById(Long id);


}
