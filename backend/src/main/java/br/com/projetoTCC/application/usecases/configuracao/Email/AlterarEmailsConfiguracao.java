package br.com.projetoTCC.application.usecases.configuracao.Email;

import br.com.projetoTCC.application.gateways.RepositorioDeEmailsConfiguracao;
import br.com.projetoTCC.domain.entities.Configuracao.Email.EmailsConfiguracao;

public class AlterarEmailsConfiguracao {

    private final RepositorioDeEmailsConfiguracao repositorio;

    public AlterarEmailsConfiguracao(RepositorioDeEmailsConfiguracao repositorio) {
        this.repositorio = repositorio;
    }

    public EmailsConfiguracao alterarEmailConfiguracao(Long indice, EmailsConfiguracao email){
        return repositorio.alterarEmailConfiguracao(indice, email);
    }
}
