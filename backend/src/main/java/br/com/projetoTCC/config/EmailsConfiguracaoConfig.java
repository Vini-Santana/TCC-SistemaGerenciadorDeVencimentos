package br.com.projetoTCC.config;

import br.com.projetoTCC.application.gateways.RepositorioDeEmailsConfiguracao;
import br.com.projetoTCC.application.gateways.RepositorioDeTempoParaNotificacao;
import br.com.projetoTCC.application.usecases.configuracao.Email.AlterarEmailsConfiguracao;
import br.com.projetoTCC.application.usecases.configuracao.Email.CriarEmailsConfiguracao;
import br.com.projetoTCC.application.usecases.configuracao.Email.DeletarEmailsConfiguracao;
import br.com.projetoTCC.application.usecases.configuracao.Email.ListarEmailsConfiguracao;
import br.com.projetoTCC.infra.gateways.Configuracao.Email.EmailsConfiguracaoEntityMapper;
import br.com.projetoTCC.infra.gateways.Configuracao.Email.RepositorioDeEmailsConfiguracaoJPA;
import br.com.projetoTCC.infra.persistence.Configuracao.Email.EmailsConfiguracaoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailsConfiguracaoConfig {

    @Bean
    ListarEmailsConfiguracao listarEmailsConfiguracao (RepositorioDeEmailsConfiguracao repositorioDeConfiguracao){
        return new ListarEmailsConfiguracao(repositorioDeConfiguracao);
    }

    @Bean
    AlterarEmailsConfiguracao alterarEmailsConfiguracao(RepositorioDeEmailsConfiguracao repositorioDeConfiguracao){
        return new AlterarEmailsConfiguracao(repositorioDeConfiguracao);
    }

    @Bean
    CriarEmailsConfiguracao configuracao(RepositorioDeEmailsConfiguracao repositorioDeConfiguracao){
        return new CriarEmailsConfiguracao(repositorioDeConfiguracao);
    }

    @Bean
    RepositorioDeEmailsConfiguracaoJPA repositorioDeEmailsConfiguracaoJPA (EmailsConfiguracaoRepository configuracaoRepository, EmailsConfiguracaoEntityMapper mapper){
        return new RepositorioDeEmailsConfiguracaoJPA(mapper, configuracaoRepository);
    }

    @Bean
    DeletarEmailsConfiguracao deletarEmailsConfiguracaoJPA (RepositorioDeEmailsConfiguracao repositorioDeConfiguracao){
        return new DeletarEmailsConfiguracao(repositorioDeConfiguracao);
    }

    @Bean
    EmailsConfiguracaoEntityMapper emailsConfiguracaoEntityMapper (){
        return new EmailsConfiguracaoEntityMapper();
    }
}
