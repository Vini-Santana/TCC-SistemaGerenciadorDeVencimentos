package br.com.projetoTCC.config;

import br.com.projetoTCC.application.gateways.RepositorioDeBaseDeDadosProduto;
import br.com.projetoTCC.application.usecases.BaseDeDadosProduto.CriarBaseDeDadosProduto;
import br.com.projetoTCC.application.usecases.BaseDeDadosProduto.ListarBaseDeDadosProduto;
import br.com.projetoTCC.infra.gateways.BaseDeDadosProduto.BaseDeDadosProdutoEntityMapper;
import br.com.projetoTCC.infra.gateways.BaseDeDadosProduto.RepositorioDeBaseDeDadosProdutoJPA;
import br.com.projetoTCC.infra.persistence.BaseDeDadosProduto.BaseDeDadosProdutoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseDeDadosProdutoConfig {

    @Bean
    CriarBaseDeDadosProduto criarBaseDeDadosProduto (RepositorioDeBaseDeDadosProduto repositorioDeBaseDeDadosProduto){
        return new CriarBaseDeDadosProduto(repositorioDeBaseDeDadosProduto);
    }
    @Bean
    ListarBaseDeDadosProduto listarBaseDeDadosProduto(RepositorioDeBaseDeDadosProduto repositorioDeBaseDeDadosProduto){
        return new ListarBaseDeDadosProduto(repositorioDeBaseDeDadosProduto);
    }

    @Bean
    RepositorioDeBaseDeDadosProdutoJPA criarRepositorioDeBaseDeDadosProdutoJPA(BaseDeDadosProdutoRepository repository, BaseDeDadosProdutoEntityMapper mapper){
        return new RepositorioDeBaseDeDadosProdutoJPA(repository, mapper);
    }

    @Bean
    BaseDeDadosProdutoEntityMapper mapper(){
        return new BaseDeDadosProdutoEntityMapper();
    }

}
