package br.com.projetoTCC.domain.entities.Configuracao.Email;

public class EmailsConfiguracao {

    private Long id;
    private String emailsParaNotificacao;

    public EmailsConfiguracao(String emailsParaNotificacao) {
        this.emailsParaNotificacao = emailsParaNotificacao;
    }

    public EmailsConfiguracao(Long id, String emailsParaNotificacao) {
        this.id = id;
        this.emailsParaNotificacao = emailsParaNotificacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmailsParaNotificacao() {
        return emailsParaNotificacao;
    }

    public void setEmailsParaNotificacao(String emailsParaNotificacao) {
        this.emailsParaNotificacao = emailsParaNotificacao;
    }
}

