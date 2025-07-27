package br.com.projetoTCC.config;

import br.com.projetoTCC.application.gateways.RepositorioDeConfiguracao;
import br.com.projetoTCC.application.gateways.RepositorioDeProduto;
import br.com.projetoTCC.application.usecases.Produto.AlterarProduto;
import br.com.projetoTCC.application.usecases.Produto.CriarProduto;
import br.com.projetoTCC.application.usecases.Produto.DeletarProduto;
import br.com.projetoTCC.application.usecases.Produto.ListarProduto;
import br.com.projetoTCC.infra.gateways.Produto.ProdutoEntityMapper;
import br.com.projetoTCC.infra.gateways.Produto.RepositorioDeProdutoJpa;
import br.com.projetoTCC.infra.persistence.Produto.ProdutoRepository;
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

    @Bean
    ListarProduto listarProduto(RepositorioDeProduto repositorioDeProduto, RepositorioDeConfiguracao repositorioDeConfiguracao){
        return new ListarProduto(repositorioDeProduto, repositorioDeConfiguracao);
    }

    @Bean
    AlterarProduto alterarProduto(RepositorioDeProduto repositorioDeProduto){
        return new AlterarProduto(repositorioDeProduto);
    }

    @Bean
    DeletarProduto deletarProduto(RepositorioDeProduto repositorioDeProduto){
        return new DeletarProduto(repositorioDeProduto);
    }
}
