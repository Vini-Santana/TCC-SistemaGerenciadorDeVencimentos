package br.com.alura.codechella.config;

import br.com.alura.codechella.application.gateways.RepositorioDeProduto;
import br.com.alura.codechella.application.usecases.CriarProduto;
import br.com.alura.codechella.infra.gateways.ProdutoEntityMapper;
import br.com.alura.codechella.infra.gateways.RepositorioDeProdutoJpa;
import br.com.alura.codechella.infra.persistence.ProdutoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProdutoConfig {

    @Bean
    CriarProduto criarProduto(RepositorioDeProduto repositorioDeProduto){
        return new CriarProduto(repositorioDeProduto);
    }

    @Bean
    RepositorioDeProdutoJpa criarRepositorioJPA(ProdutoRepository repository, ProdutoEntityMapper mapper){
        return new RepositorioDeProdutoJpa(repository, mapper);
    }

    @Bean
    ProdutoEntityMapper retornaMapper(){
        return new ProdutoEntityMapper();
    }
}
