package br.com.projetoTCC.infra.persistence.Configuracao.TempoParaNotificacao;

import jakarta.persistence.*;

@Entity
@Table(name = "tempoParaNotificacaoConfiguracao")
public class TempoParaNotificacaoConfiguracaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private Integer tempoParaNotificacaoDeValidade;

    @Column(nullable = false)
    private String tipoTempo;

    public TempoParaNotificacaoConfiguracaoEntity() {}

    public TempoParaNotificacaoConfiguracaoEntity(Integer tempoParaNotificacaoDeValidade, String tipoTempo) {
        this.tempoParaNotificacaoDeValidade = tempoParaNotificacaoDeValidade;
        this.tipoTempo = tipoTempo;
    }

    public TempoParaNotificacaoConfiguracaoEntity(Long id, Integer tempoParaNotificacaoDeValidade, String tipoTempo) {
        this.id = id;
        this.tempoParaNotificacaoDeValidade = tempoParaNotificacaoDeValidade;
        this.tipoTempo = tipoTempo;
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
