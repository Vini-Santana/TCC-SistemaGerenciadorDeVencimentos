package br.com.projetoTCC.application.usecases.Configuracao;

import br.com.projetoTCC.application.gateways.RepositorioDeConfiguracao;
import br.com.projetoTCC.domain.entities.Conficuracao.Configuracao;

public class AlterarConfiguracao {

    private final RepositorioDeConfiguracao repositorioDeConfiguracao;

    public AlterarConfiguracao(RepositorioDeConfiguracao repositorioDeConfiguracao) {
        this.repositorioDeConfiguracao = repositorioDeConfiguracao;
    }

    public Configuracao alterarConfiguracao(Configuracao configuracao){
        return repositorioDeConfiguracao.alterarConfiguracao(configuracao);
    }

    public Configuracao alterarEmailConfiguracao(Long indice, String email){
        return repositorioDeConfiguracao.alterarEmailConfiguracao(indice, email);
    }

    public Configuracao alterarTempoParaNotificacaoDeValidadeConfiguracao(Long indice, Integer dias){
        return repositorioDeConfiguracao.alterarTempoParaNotificacaoDeValidadeConfiguracao(indice, dias);
    }
}
