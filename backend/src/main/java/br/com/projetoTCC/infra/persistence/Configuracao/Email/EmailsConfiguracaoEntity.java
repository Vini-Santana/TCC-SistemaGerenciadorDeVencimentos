package br.com.projetoTCC.infra.persistence.Configuracao.Email;

import jakarta.persistence.*;

@Entity
@Table(name = "emailsConfiguracao")
public class EmailsConfiguracaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "email", unique = true)
    private String emailsParaNotificacao;

    public EmailsConfiguracaoEntity(){}

    public EmailsConfiguracaoEntity(String emailsParaNotificacao) {
        this.emailsParaNotificacao = emailsParaNotificacao;
    }

    public EmailsConfiguracaoEntity(Long id, String emailsParaNotificacao) {
        this.id = id;
        this.emailsParaNotificacao = emailsParaNotificacao;
    }

    public Long getId() {
        return id;
    }

    public String getEmailsParaNotificacao() {
        return emailsParaNotificacao;
    }

    public void setEmailsParaNotificacao(String emailsParaNotificacao) {
        this.emailsParaNotificacao = emailsParaNotificacao;
    }
}
