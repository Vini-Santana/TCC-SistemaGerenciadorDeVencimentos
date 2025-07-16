package br.com.projetoTCC.infra.persistence.Configuracao;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "configuracao")
public class ConfiguracaoEntity {

    @Id
    private Long id = 1L;
    @ElementCollection
    @CollectionTable(name = "emails_para_notificacao", joinColumns = @JoinColumn(name = "configuracao_id"))
    @Column(name = "email")
    private List<String> emailsParaNotificacao;
    @Column(nullable = false)    private Integer tempoParaNotificacaoDeValidade;

    public ConfiguracaoEntity(){}

    public ConfiguracaoEntity(List<String> emailsParaNotificacao, Integer tempoParaNotificacaoDeValidade) {
        this.emailsParaNotificacao = emailsParaNotificacao;
        this.tempoParaNotificacaoDeValidade = tempoParaNotificacaoDeValidade;
    }

    public Integer getTempoParaNotificacaoDeValidade() {
        return tempoParaNotificacaoDeValidade;
    }

    public void setTempoParaNotificacaoDeValidade(Integer tempoParaNotificacaoDeValidade) {
        this.tempoParaNotificacaoDeValidade = tempoParaNotificacaoDeValidade;
    }

    public List<String> getEmailsParaNotificacao() {
        return emailsParaNotificacao;
    }

    public void setEmailsParaNotificacao(List<String> emailsParaNotificacao) {
        this.emailsParaNotificacao = emailsParaNotificacao;
    }
}
