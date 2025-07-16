package br.com.projetoTCC.application.usecases.Configuracao;

import br.com.projetoTCC.application.gateways.RepositorioDeConfiguracao;
import br.com.projetoTCC.domain.entities.Conficuracao.Configuracao;

public class CriarConfiguracao {

    private final RepositorioDeConfiguracao repositorioDeConfiguracao;

    public CriarConfiguracao(RepositorioDeConfiguracao repositorioDeConfiguracao) {
        this.repositorioDeConfiguracao = repositorioDeConfiguracao;
    }

    public Configuracao criarConfiguracao(Configuracao configuracao){
        return repositorioDeConfiguracao.criarConfiguracao(configuracao);
    }
}
