package br.com.projetoTCC.domain.entities.Configuracao.TempoParaNotificacao;

public class TempoParaNotificacaoConfiguracao {

    private Long id;
    private Integer tempoParaNotificacaoDeValidade;
    private String tipoTempo;

    public TempoParaNotificacaoConfiguracao(Integer tempoParaNotificacaoDeValidade, String tipoTempo) {
        this.tipoTempo = tipoTempo;
        this.tempoParaNotificacaoDeValidade = tempoParaNotificacaoDeValidade;
    }

    public TempoParaNotificacaoConfiguracao(Long id, Integer tempoParaNotificacaoDeValidade, String tipoTempo) {
        this.id = id;
        this.tipoTempo = tipoTempo;
        this.tempoParaNotificacaoDeValidade = tempoParaNotificacaoDeValidade;
    }

    public Long getId() {
        return id;
    }

    public Integer getTempoParaNotificacaoDeValidade() {
        return tempoParaNotificacaoDeValidade;
    }

    public void setTempoParaNotificacaoDeValidade(Integer tempoParaNotificacaoDeValidade) {
        this.tempoParaNotificacaoDeValidade = tempoParaNotificacaoDeValidade;
    }

    public String getTipoTempo() {
        return tipoTempo;
    }

    public void setTipoTempo(String tipoTempo) {
        this.tipoTempo = tipoTempo;
    }
}

