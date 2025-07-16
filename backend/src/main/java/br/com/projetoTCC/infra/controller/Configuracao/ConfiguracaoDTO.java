package br.com.projetoTCC.infra.controller.Configuracao;

import java.util.List;

public record ConfiguracaoDTO(
        List<String> emailsParaNotificacao,
        Integer tempoParaNotificacaoDeValidade) {}
