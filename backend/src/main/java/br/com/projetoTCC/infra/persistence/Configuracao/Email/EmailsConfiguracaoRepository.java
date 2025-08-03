package br.com.projetoTCC.infra.persistence.Configuracao.Email;

import br.com.projetoTCC.domain.entities.Configuracao.Email.EmailsConfiguracao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmailsConfiguracaoRepository extends JpaRepository<EmailsConfiguracaoEntity, Long> {

//    List<EmailsConfiguracaoEntity> findByEmailsParaNotificacao(String email);
//    List<EmailsConfiguracaoEntity> findBytempoParaNotificacaoDeValidade(String dia);
    EmailsConfiguracaoEntity findTopByOrderByIdAsc();

}
