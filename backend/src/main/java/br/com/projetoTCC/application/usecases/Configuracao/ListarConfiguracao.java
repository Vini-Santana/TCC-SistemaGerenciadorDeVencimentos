package br.com.projetoTCC.application.usecases.Configuracao;

import br.com.projetoTCC.application.gateways.RepositorioDeConfiguracao;
import br.com.projetoTCC.domain.entities.Conficuracao.Configuracao;

import java.util.List;

public class ListarConfiguracao {

    private final RepositorioDeConfiguracao repositorioDeConfiguracao;

    public ListarConfiguracao(RepositorioDeConfiguracao repositorioDeConfiguracao) {
        this.repositorioDeConfiguracao = repositorioDeConfiguracao;
    }

    public List<Configuracao> listarConfiguracao(){
        return repositorioDeConfiguracao.listarConfiguracao();
    }

    public List<String> listarEmailsConfiguracao(){
        return repositorioDeConfiguracao.listarEmailsConfiguracao();
    }

    public List<Integer> listarTempoParaNotificacaoDeValidadeConfiguracao(){
        return repositorioDeConfiguracao.listarTempoParaNotificacaoDeValidadeConfiguracao();
    }
}
