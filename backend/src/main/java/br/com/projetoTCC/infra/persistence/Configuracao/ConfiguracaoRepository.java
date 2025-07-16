package br.com.projetoTCC.infra.persistence.Configuracao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConfiguracaoRepository extends JpaRepository<ConfiguracaoEntity, Long> {

//    List<ConfiguracaoEntity> findByEmailsParaNotificacao(String email);
//    List<ConfiguracaoEntity> findBytempoParaNotificacaoDeValidade(String dia);
}
