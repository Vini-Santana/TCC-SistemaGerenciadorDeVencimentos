package br.com.projetoTCC.config;

import br.com.projetoTCC.application.gateways.RepositorioDeEmailsConfiguracao;
import br.com.projetoTCC.application.gateways.RepositorioDeTempoParaNotificacao;
import br.com.projetoTCC.application.usecases.configuracao.Email.DeletarEmailsConfiguracao;
import br.com.projetoTCC.application.usecases.configuracao.TempoNotificacao.AlterarTempoParaNotificacaoConfiguracao;
import br.com.projetoTCC.application.usecases.configuracao.TempoNotificacao.CriarTempoParaNotificacaoConfiguracao;
import br.com.projetoTCC.application.usecases.configuracao.TempoNotificacao.DeletarTempoParaNotificacaoConfiguracao;
import br.com.projetoTCC.application.usecases.configuracao.TempoNotificacao.ListarTempoParaNotificacaoConfiguracao;
import br.com.projetoTCC.infra.gateways.Configuracao.TempoParaNotificacao.RepositorioDeTempoParaNotificacaoJPA;
import br.com.projetoTCC.infra.gateways.Configuracao.TempoParaNotificacao.TempoParaNotificacaoConfiguracaoEntityMapper;
import br.com.projetoTCC.infra.persistence.Configuracao.TempoParaNotificacao.TempoParaNotificacaoConfiguracaoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TempoParaNotificacaoConfig {

    @Bean
    ListarTempoParaNotificacaoConfiguracao listarTempoParaNotificacaoConfiguracao (RepositorioDeTempoParaNotificacao repositorioDeConfiguracao){
        return new ListarTempoParaNotificacaoConfiguracao(repositorioDeConfiguracao);
    }

    @Bean
    AlterarTempoParaNotificacaoConfiguracao alterarTempoParaNotificacaoConfiguracao(RepositorioDeTempoParaNotificacao repositorioDeConfiguracao){
        return new AlterarTempoParaNotificacaoConfiguracao(repositorioDeConfiguracao);
    }

    @Bean
    CriarTempoParaNotificacaoConfiguracao criarTempoParaNotificacaoConfiguracao(RepositorioDeTempoParaNotificacao repositorioDeConfiguracao){
        return new CriarTempoParaNotificacaoConfiguracao(repositorioDeConfiguracao);
    }

    @Bean
    RepositorioDeTempoParaNotificacaoJPA repositorioDeTempoParaNotificacaoJPA (TempoParaNotificacaoConfiguracaoEntityMapper mapper, TempoParaNotificacaoConfiguracaoRepository configuracaoRepository){
        return new RepositorioDeTempoParaNotificacaoJPA(mapper, configuracaoRepository);
    }

    @Bean
    DeletarTempoParaNotificacaoConfiguracao deletarTempoConfiguracaoJPA (RepositorioDeTempoParaNotificacao repositorioDeConfiguracao){
        return new DeletarTempoParaNotificacaoConfiguracao(repositorioDeConfiguracao);
    }

    @Bean
    TempoParaNotificacaoConfiguracaoEntityMapper tempoParaNotificacaoConfiguracaoEntityMapper (){
        return new TempoParaNotificacaoConfiguracaoEntityMapper();
    }
}
