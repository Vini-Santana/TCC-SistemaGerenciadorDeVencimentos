package br.com.projetoTCC.domain.entities.Conficuracao;

import java.util.List;

public class Configuracao {

    private List<String> emailsParaNotificacao;
    private Integer tempoParaNotificacaoDeValidade;

    public Configuracao(List<String> emailsParaNotificacao, Integer tempoParaNotificacaoDeValidade) {
        this.emailsParaNotificacao = emailsParaNotificacao;
        this.tempoParaNotificacaoDeValidade = tempoParaNotificacaoDeValidade;
    }

    public List<String> getEmailsParaNotificacao() {
        return emailsParaNotificacao;
    }

    public void setEmailsParaNotificacao(List<String> emailsParaNotificacao) {
        this.emailsParaNotificacao = emailsParaNotificacao;
    }

    public Integer getTempoParaNotificacaoDeValidade() {
        return tempoParaNotificacaoDeValidade;
    }

    public void setTempoParaNotificacaoDeValidade(Integer tempoParaNotificacaoDeValidade) {
        this.tempoParaNotificacaoDeValidade = tempoParaNotificacaoDeValidade;
    }
}

