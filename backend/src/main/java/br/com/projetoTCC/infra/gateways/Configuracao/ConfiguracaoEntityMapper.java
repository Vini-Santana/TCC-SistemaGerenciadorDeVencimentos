package br.com.projetoTCC.infra.gateways.Configuracao;


import br.com.projetoTCC.domain.entities.Conficuracao.Configuracao;
import br.com.projetoTCC.infra.persistence.Configuracao.ConfiguracaoEntity;

public class ConfiguracaoEntityMapper {

    public ConfiguracaoEntity toEntity (Configuracao configuracao){
        return new ConfiguracaoEntity(configuracao.getEmailsParaNotificacao(), configuracao.getTempoParaNotificacaoDeValidade());
    }

    public Configuracao toDomain(ConfiguracaoEntity entity){
        return new Configuracao(entity.getEmailsParaNotificacao(), entity.getTempoParaNotificacaoDeValidade());
    }
}
