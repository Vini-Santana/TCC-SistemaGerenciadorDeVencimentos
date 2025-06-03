package br.com.projetoTCC.config;

import br.com.projetoTCC.application.gateways.RepositorioDeBaseDeDadosProduto;
import br.com.projetoTCC.application.usecases.BaseDeDadosProduto.AlterarBaseDeDadosProduto;
import br.com.projetoTCC.application.usecases.BaseDeDadosProduto.CriarBaseDeDadosProduto;
import br.com.projetoTCC.application.usecases.BaseDeDadosProduto.DeletarBaseDeDadosProduto;
import br.com.projetoTCC.application.usecases.BaseDeDadosProduto.ListarBaseDeDadosProduto;
import br.com.projetoTCC.infra.gateways.BaseDeDadosProduto.BaseDeDadosProdutoEntityMapper;
import br.com.projetoTCC.infra.gateways.BaseDeDadosProduto.RepositorioDeBaseDeDadosProdutoJPA;
import br.com.projetoTCC.infra.persistence.BaseDeDadosProduto.BaseDeDadosProdutoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BaseDeDadosProdutoConfig {

    @Bean
    CriarBaseDeDadosProduto criarBaseDeDadosBaseDeDadosProduto(RepositorioDeBaseDeDadosProduto repositorioDeBaseDeDadosProduto){
        return new CriarBaseDeDadosProduto(repositorioDeBaseDeDadosProduto);
    }

    @Bean
    RepositorioDeBaseDeDadosProdutoJPA criarRepositorioBaseDeDadosProdutoJPA(BaseDeDadosProdutoRepository repository, BaseDeDadosProdutoEntityMapper mapper){
        return new RepositorioDeBaseDeDadosProdutoJPA(repository, mapper);
    }

    @Bean
    BaseDeDadosProdutoEntityMapper retornaBaseDeDadosProdutoMapper(){
        return new BaseDeDadosProdutoEntityMapper();
    }

    @Bean
    ListarBaseDeDadosProduto listarBaseDeDadosProduto(RepositorioDeBaseDeDadosProduto repositorioDeBaseDeDadosProduto){
        return new ListarBaseDeDadosProduto(repositorioDeBaseDeDadosProduto);
    }

    @Bean
    AlterarBaseDeDadosProduto alterarBaseDeDadosProduto(RepositorioDeBaseDeDadosProduto repositorioDeBaseDeDadosProduto){
        return new AlterarBaseDeDadosProduto(repositorioDeBaseDeDadosProduto);
    }

    @Bean
    DeletarBaseDeDadosProduto deletarBaseDeDadosProduto(RepositorioDeBaseDeDadosProduto repositorioDeBaseDeDadosProduto){
        return new DeletarBaseDeDadosProduto(repositorioDeBaseDeDadosProduto);
    }

}
