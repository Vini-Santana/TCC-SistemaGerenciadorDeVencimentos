package br.com.projetoTCC.application.gateways;

import br.com.projetoTCC.domain.entities.Configuracao.TempoParaNotificacao.TempoParaNotificacaoConfiguracao;

import java.util.List;

;

public interface RepositorioDeTempoParaNotificacao {

    TempoParaNotificacaoConfiguracao criarTempoParaNotificacaoConfiguracao (TempoParaNotificacaoConfiguracao tempoParaNotificacaoConfiguracao);
    List<TempoParaNotificacaoConfiguracao> listarTempoParaNotificacaoConfiguracao();
    List<TempoParaNotificacaoConfiguracao> listarTempoParaNotificacaoConfiguracaoReverso();
    TempoParaNotificacaoConfiguracao alterarTempoParaNotificacaoConfiguracao(Long indice, TempoParaNotificacaoConfiguracao dias);
    TempoParaNotificacaoConfiguracao deletarTempoParaNotificacaoConfiguracao(Long indice, TempoParaNotificacaoConfiguracao dias);
    TempoParaNotificacaoConfiguracao listarTempoPorId(Long id);
}
