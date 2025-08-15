package br.com.projetoTCC.infra.gateways.Configuracao.TempoParaNotificacao;

import br.com.projetoTCC.application.gateways.RepositorioDeTempoParaNotificacao;
import br.com.projetoTCC.domain.entities.Configuracao.TempoParaNotificacao.TempoParaNotificacaoConfiguracao;
import br.com.projetoTCC.domain.exceptions.ProdutoNotFoundExceptionId;
import br.com.projetoTCC.domain.exceptions.TempoParaNotificacaoNotFoundExceptionId;
import br.com.projetoTCC.infra.persistence.Configuracao.TempoParaNotificacao.TempoParaNotificacaoConfiguracaoEntity;
import br.com.projetoTCC.infra.persistence.Configuracao.TempoParaNotificacao.TempoParaNotificacaoConfiguracaoRepository;
import br.com.projetoTCC.infra.persistence.Produto.ProdutoEntity;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeTempoParaNotificacaoJPA implements RepositorioDeTempoParaNotificacao {

    private final TempoParaNotificacaoConfiguracaoEntityMapper mapper;
    private final TempoParaNotificacaoConfiguracaoRepository repository;

    public RepositorioDeTempoParaNotificacaoJPA(TempoParaNotificacaoConfiguracaoEntityMapper mapper, TempoParaNotificacaoConfiguracaoRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public TempoParaNotificacaoConfiguracao criarTempoParaNotificacaoConfiguracao(TempoParaNotificacaoConfiguracao tempoParaNotificacaoConfiguracao) {
        TempoParaNotificacaoConfiguracaoEntity entity = mapper.toEntity(tempoParaNotificacaoConfiguracao);
        repository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public List<TempoParaNotificacaoConfiguracao> listarTempoParaNotificacaoConfiguracao() {

        return repository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<TempoParaNotificacaoConfiguracao> listarTempoParaNotificacaoConfiguracaoReverso() {
        return repository.findAll().stream()
                .filter(entity -> entity.getId() != 1)
                .map(mapper::toDomain)
                .sorted(Comparator.comparingInt(TempoParaNotificacaoConfiguracao::getTempoParaNotificacaoDeValidade).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public TempoParaNotificacaoConfiguracao alterarTempoParaNotificacaoConfiguracao(Long indice, TempoParaNotificacaoConfiguracao tempo) {
        TempoParaNotificacaoConfiguracaoEntity entity = new TempoParaNotificacaoConfiguracaoEntity(indice, tempo.getTempoParaNotificacaoDeValidade(), tempo.getTipoTempo());
        repository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public TempoParaNotificacaoConfiguracao deletarTempoParaNotificacaoConfiguracao(Long indice, TempoParaNotificacaoConfiguracao dias) {
        repository.deleteById(indice);
        return dias;
    }

    @Override
    public TempoParaNotificacaoConfiguracao listarTempoPorId(Long id) {
        TempoParaNotificacaoConfiguracaoEntity entity = repository.findById(id)
                .orElseThrow(() -> new TempoParaNotificacaoNotFoundExceptionId(id));
        return mapper.toDomain(entity);
    }
}
