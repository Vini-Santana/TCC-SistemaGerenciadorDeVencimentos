package br.com.projetoTCC.infra.persistence.Configuracao.TempoParaNotificacao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TempoParaNotificacaoConfiguracaoRepository extends JpaRepository<TempoParaNotificacaoConfiguracaoEntity, Long> {

//    List<ConfiguracaoEntity> findByEmailsParaNotificacao(String email);
//    List<ConfiguracaoEntity> findBytempoParaNotificacaoDeValidade(String dia);
      TempoParaNotificacaoConfiguracaoEntity findTopByOrderByIdAsc();

}
