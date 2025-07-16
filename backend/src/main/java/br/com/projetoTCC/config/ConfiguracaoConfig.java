package br.com.projetoTCC.config;

import br.com.projetoTCC.application.gateways.RepositorioDeConfiguracao;
import br.com.projetoTCC.application.usecases.Configuracao.AlterarConfiguracao;
import br.com.projetoTCC.application.usecases.Configuracao.CriarConfiguracao;
import br.com.projetoTCC.application.usecases.Configuracao.ListarConfiguracao;
import br.com.projetoTCC.infra.gateways.BaseDeDadosProduto.RepositorioDeBaseDeDadosProdutoJPA;
import br.com.projetoTCC.infra.gateways.Configuracao.ConfiguracaoEntityMapper;
import br.com.projetoTCC.infra.gateways.Configuracao.RepositorioDeConfiguracaoJPA;
import br.com.projetoTCC.infra.persistence.Configuracao.ConfiguracaoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracaoConfig {

    @Bean
    ListarConfiguracao listarConfiguracao (RepositorioDeConfiguracao repositorioDeConfiguracao){
        return new ListarConfiguracao(repositorioDeConfiguracao);
    }

    @Bean
    AlterarConfiguracao alterarConfiguracao(RepositorioDeConfiguracao repositorioDeConfiguracao){
        return new AlterarConfiguracao(repositorioDeConfiguracao);
    }

    @Bean
    CriarConfiguracao criarConfiguracao(RepositorioDeConfiguracao repositorioDeConfiguracao){
        return new CriarConfiguracao(repositorioDeConfiguracao);
    }

    @Bean
    RepositorioDeConfiguracaoJPA repositorioDeBaseDeDadosProdutoJPA (ConfiguracaoRepository configuracaoRepository, ConfiguracaoEntityMapper mapper){
        return new RepositorioDeConfiguracaoJPA(mapper, configuracaoRepository);
    }

    @Bean ConfiguracaoEntityMapper mapper (){
        return new ConfiguracaoEntityMapper();
    }
}
