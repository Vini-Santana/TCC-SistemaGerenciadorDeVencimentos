package br.com.projetoTCC.infra.gateways.Configuracao.TempoParaNotificacao;


import br.com.projetoTCC.domain.entities.Configuracao.TempoParaNotificacao.TempoParaNotificacaoConfiguracao;
import br.com.projetoTCC.infra.persistence.Configuracao.TempoParaNotificacao.TempoParaNotificacaoConfiguracaoEntity;

public class TempoParaNotificacaoConfiguracaoEntityMapper {

    public TempoParaNotificacaoConfiguracaoEntity toEntity (TempoParaNotificacaoConfiguracao configuracao){
        return new TempoParaNotificacaoConfiguracaoEntity(configuracao.getTempoParaNotificacaoDeValidade(), configuracao.getTipoTempo());
    }

    public TempoParaNotificacaoConfiguracao toDomain(TempoParaNotificacaoConfiguracaoEntity entity){
        return new TempoParaNotificacaoConfiguracao(entity.getId(), entity.getTempoParaNotificacaoDeValidade(), entity.getTipoTempo());
    }
}
