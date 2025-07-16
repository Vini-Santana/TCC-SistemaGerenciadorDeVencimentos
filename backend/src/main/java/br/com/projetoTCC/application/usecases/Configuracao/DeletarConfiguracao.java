package br.com.projetoTCC.application.usecases.Configuracao;

import br.com.projetoTCC.application.gateways.RepositorioDeConfiguracao;
import br.com.projetoTCC.domain.entities.Conficuracao.Configuracao;

public class DeletarConfiguracao {
    private final RepositorioDeConfiguracao repositorioDeConfiguracao;

    public DeletarConfiguracao(RepositorioDeConfiguracao repositorioDeConfiguracao){
        this.repositorioDeConfiguracao = repositorioDeConfiguracao;
    }

    public Configuracao deletarEmailConfiguracao(Long indice, String email){
        return repositorioDeConfiguracao.deletarEmailConfiguracao(indice, email);
    }
}
