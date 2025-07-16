package br.com.projetoTCC.application.gateways;

import br.com.projetoTCC.domain.entities.Conficuracao.Configuracao;;

import java.time.LocalDate;
import java.util.List;

public interface RepositorioDeConfiguracao {

    Configuracao criarConfiguracao(Configuracao Configuracao);
    List<Configuracao> listarConfiguracao();
    List<String> listarEmailsConfiguracao();
    List<Integer> listarTempoParaNotificacaoDeValidadeConfiguracao();
    Configuracao deletarEmailConfiguracao(Long indice, String email);
    Configuracao alterarConfiguracao(Configuracao configuracao);
    Configuracao alterarEmailConfiguracao(Long indice, String email);
    Configuracao alterarTempoParaNotificacaoDeValidadeConfiguracao(Long indice, Integer dias);

}
