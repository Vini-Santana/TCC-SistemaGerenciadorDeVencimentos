package br.com.projetoTCC.application.usecases.configuracao.Email;

import br.com.projetoTCC.application.gateways.RepositorioDeEmailsConfiguracao;
import br.com.projetoTCC.domain.entities.Configuracao.Email.EmailsConfiguracao;

public class CriarEmailsConfiguracao {

    private final RepositorioDeEmailsConfiguracao repositorio;

    public CriarEmailsConfiguracao(RepositorioDeEmailsConfiguracao repositorioDeEmailsConfiguracao) {
        this.repositorio = repositorioDeEmailsConfiguracao;
    }

    public EmailsConfiguracao criarEmailConfiguracao(EmailsConfiguracao configuracao){
        return repositorio.criarEmailConfiguracao(configuracao);
    }
}
