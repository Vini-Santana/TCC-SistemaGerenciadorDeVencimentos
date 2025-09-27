package br.com.projetoTCC.application.usecases.configuracao.TempoNotificacao;

import br.com.projetoTCC.application.gateways.RepositorioDeTempoParaNotificacao;
import br.com.projetoTCC.domain.entities.Configuracao.TempoParaNotificacao.TempoParaNotificacaoConfiguracao;

public class AlterarTempoParaNotificacaoConfiguracao {

    private final RepositorioDeTempoParaNotificacao repositorio;

    public AlterarTempoParaNotificacaoConfiguracao(RepositorioDeTempoParaNotificacao repositorio) {
        this.repositorio = repositorio;
    }

    public TempoParaNotificacaoConfiguracao alterarConfiguracao(Long indice, TempoParaNotificacaoConfiguracao configuracao){
        return repositorio.alterarTempoParaNotificacaoConfiguracao(indice, configuracao);
    }
}
