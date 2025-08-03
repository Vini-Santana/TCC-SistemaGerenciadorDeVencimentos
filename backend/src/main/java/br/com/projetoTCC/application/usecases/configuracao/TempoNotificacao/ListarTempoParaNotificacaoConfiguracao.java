package br.com.projetoTCC.application.usecases.configuracao.TempoNotificacao;

import br.com.projetoTCC.application.gateways.RepositorioDeTempoParaNotificacao;
import br.com.projetoTCC.domain.entities.Configuracao.TempoParaNotificacao.TempoParaNotificacaoConfiguracao;
import br.com.projetoTCC.domain.entities.Produto.Produto;

import java.util.List;

public class ListarTempoParaNotificacaoConfiguracao {

    private final RepositorioDeTempoParaNotificacao repositorioDeConfiguracao;

    public ListarTempoParaNotificacaoConfiguracao(RepositorioDeTempoParaNotificacao repositorioDeConfiguracao) {
        this.repositorioDeConfiguracao = repositorioDeConfiguracao;
    }

    public List<TempoParaNotificacaoConfiguracao> listarTempoParaNotificacaoDeValidadeConfiguracao(){
        return repositorioDeConfiguracao.listarTempoParaNotificacaoConfiguracao();
    }

    public TempoParaNotificacaoConfiguracao listarTempoPorId(Long id){
        return repositorioDeConfiguracao.listarTempoPorId(id);
    }

}
