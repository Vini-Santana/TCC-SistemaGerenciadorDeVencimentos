package br.com.projetoTCC.infra.gateways.Configuracao.Email;


import br.com.projetoTCC.domain.entities.Configuracao.Email.EmailsConfiguracao;
import br.com.projetoTCC.infra.persistence.Configuracao.Email.EmailsConfiguracaoEntity;

public class EmailsConfiguracaoEntityMapper {

    public EmailsConfiguracaoEntity toEntity (EmailsConfiguracao configuracao){
        return new EmailsConfiguracaoEntity(configuracao.getEmailsParaNotificacao());
    }

    public EmailsConfiguracao toDomain(EmailsConfiguracaoEntity entity){
        return new EmailsConfiguracao(entity.getId(), entity.getEmailsParaNotificacao());
    }
}
