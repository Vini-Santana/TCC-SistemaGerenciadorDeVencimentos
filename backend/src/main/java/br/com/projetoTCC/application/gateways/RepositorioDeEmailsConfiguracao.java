package br.com.projetoTCC.application.gateways;

import br.com.projetoTCC.domain.entities.Configuracao.Email.EmailsConfiguracao;

import java.util.List;

;

public interface RepositorioDeEmailsConfiguracao {

    EmailsConfiguracao criarEmailConfiguracao(EmailsConfiguracao EmailsConfiguracao);
    List<EmailsConfiguracao> listarEmailsConfiguracao();
    EmailsConfiguracao deletarEmailConfiguracao(Long indice, EmailsConfiguracao email);
    EmailsConfiguracao alterarEmailConfiguracao(Long indice, EmailsConfiguracao email);
}
