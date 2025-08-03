package br.com.projetoTCC.infra.controller.Configuracao.TempoParaNotificacao;

public record TempoParaNotificacaoConfiguracaoDTO(
        Long id,
        Integer tempoParaNotificacaoDeValidade,
        String tipoTempo) {}
