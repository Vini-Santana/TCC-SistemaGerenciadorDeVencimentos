package br.com.projetoTCC.application.usecases.configuracao.TempoNotificacao;

import br.com.projetoTCC.application.gateways.RepositorioDeTempoParaNotificacao;
import br.com.projetoTCC.domain.entities.Configuracao.TempoParaNotificacao.TempoParaNotificacaoConfiguracao;

public class CriarTempoParaNotificacaoConfiguracao {

    private final RepositorioDeTempoParaNotificacao repositorioDeConfiguracao;

    public CriarTempoParaNotificacaoConfiguracao(RepositorioDeTempoParaNotificacao repositorioDeConfiguracao) {
        this.repositorioDeConfiguracao = repositorioDeConfiguracao;
    }

    public TempoParaNotificacaoConfiguracao criarTempoConfiguracao(TempoParaNotificacaoConfiguracao configuracao){
        return repositorioDeConfiguracao.criarTempoParaNotificacaoConfiguracao(configuracao);
    }
}
