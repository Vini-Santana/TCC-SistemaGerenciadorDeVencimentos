package br.com.projetoTCC.application.usecases.configuracao.TempoNotificacao;

import br.com.projetoTCC.application.gateways.RepositorioDeTempoParaNotificacao;
import br.com.projetoTCC.domain.entities.Configuracao.TempoParaNotificacao.TempoParaNotificacaoConfiguracao;

public class DeletarTempoParaNotificacaoConfiguracao {
    private final RepositorioDeTempoParaNotificacao repositorioDeConfiguracao;

    public DeletarTempoParaNotificacaoConfiguracao(RepositorioDeTempoParaNotificacao repositorioDeConfiguracao){
        this.repositorioDeConfiguracao = repositorioDeConfiguracao;
    }

    public TempoParaNotificacaoConfiguracao deletarTempoConfiguracao(Long indice, TempoParaNotificacaoConfiguracao tempo){
        return repositorioDeConfiguracao.deletarTempoParaNotificacaoConfiguracao(indice, tempo);
    }
}
