package br.com.projetoTCC.application.usecases.configuracao.Email;

import br.com.projetoTCC.application.gateways.RepositorioDeEmailsConfiguracao;
import br.com.projetoTCC.domain.entities.Configuracao.Email.EmailsConfiguracao;

public class DeletarEmailsConfiguracao {
    private final RepositorioDeEmailsConfiguracao repositorio;

    public DeletarEmailsConfiguracao(RepositorioDeEmailsConfiguracao repositorio) {
        this.repositorio = repositorio;
    }

    public EmailsConfiguracao deletarEmailConfiguracao(Long indice, EmailsConfiguracao email){
        return repositorio.deletarEmailConfiguracao(indice, email);
    }
}
