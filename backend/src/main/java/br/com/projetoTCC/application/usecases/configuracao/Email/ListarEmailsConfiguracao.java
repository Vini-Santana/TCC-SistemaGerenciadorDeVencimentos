package br.com.projetoTCC.application.usecases.configuracao.Email;

import br.com.projetoTCC.application.gateways.RepositorioDeEmailsConfiguracao;
import br.com.projetoTCC.domain.entities.Configuracao.Email.EmailsConfiguracao;

import java.util.List;

public class ListarEmailsConfiguracao {

    private final RepositorioDeEmailsConfiguracao repositorio;

    public ListarEmailsConfiguracao(RepositorioDeEmailsConfiguracao repositorio) {
        this.repositorio = repositorio;
    }

    public List<EmailsConfiguracao> listarEmailsConfiguracao(){
        return repositorio.listarEmailsConfiguracao();
    }

}
