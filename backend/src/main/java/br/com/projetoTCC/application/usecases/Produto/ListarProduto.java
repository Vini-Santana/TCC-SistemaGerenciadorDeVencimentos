package br.com.projetoTCC.application.usecases.Produto;

import br.com.projetoTCC.application.gateways.RepositorioDeProduto;
import br.com.projetoTCC.application.gateways.RepositorioDeTempoParaNotificacao;
import br.com.projetoTCC.domain.entities.Configuracao.TempoParaNotificacao.TempoParaNotificacaoConfiguracao;
import br.com.projetoTCC.domain.entities.Produto.Produto;

import java.time.LocalDate;
import java.util.List;

public class ListarProduto {

    final RepositorioDeProduto repositorioDeProduto;
    final RepositorioDeTempoParaNotificacao repositorioDeConfiguracao;

    public ListarProduto(RepositorioDeProduto repositorioDeProduto, RepositorioDeTempoParaNotificacao repositorioDeConfiguracao) {
        this.repositorioDeProduto = repositorioDeProduto;
        this.repositorioDeConfiguracao = repositorioDeConfiguracao;
    }

    public List<Produto> listarTodosProduto(){
        return repositorioDeProduto.listarTodosProduto();
    }

    public List<Produto> listarProdutoPorNome(String nome){
        return repositorioDeProduto.listarProdutoPorNome(nome);
    }

    public List<Produto> listarProdutoPorCodigo(String codigo){
        return repositorioDeProduto.listarProdutoPorCodigo(codigo);
    }

    public List<Produto> listarProdutoPorQuantidade(Integer quantidade){
        return repositorioDeProduto.listarProdutoPorQuantidade(quantidade);
    }

    public List<Produto> listarProdutoPorValidade(LocalDate validade){
        return repositorioDeProduto.listarProdutoPorValidade(validade);
    }

    public Produto listarProdutoPorId(Long id){
        return repositorioDeProduto.listarProdutoPorId(id);
    }

    public Boolean isAVencer(Produto p) {

        LocalDate dataAtual = LocalDate.now();
        LocalDate dataDeValidade = p.getValidade();
        TempoParaNotificacaoConfiguracao tempoParaNotificacaoDeValidade = repositorioDeConfiguracao.listarTempoPorId(1L);
            if(tempoParaNotificacaoDeValidade.getTipoTempo().equals("TempoAVencer")){
                if (dataAtual.isAfter(dataDeValidade.minusDays(tempoParaNotificacaoDeValidade.getTempoParaNotificacaoDeValidade())) && dataAtual.isBefore(dataDeValidade)) {
                    return true;
                }else {
                    return false;
                }
            }
        return false;

    }
}
