package br.com.projetoTCC.infra.gateways.Configuracao;

import br.com.projetoTCC.application.gateways.RepositorioDeConfiguracao;
import br.com.projetoTCC.domain.entities.Conficuracao.Configuracao;
import br.com.projetoTCC.infra.persistence.Configuracao.ConfiguracaoEntity;
import br.com.projetoTCC.infra.persistence.Configuracao.ConfiguracaoRepository;

import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeConfiguracaoJPA implements RepositorioDeConfiguracao{

    private final ConfiguracaoEntityMapper mapper;
    private final ConfiguracaoRepository repository;

    public RepositorioDeConfiguracaoJPA(ConfiguracaoEntityMapper configuracaoEntityMapper, ConfiguracaoRepository configuracaoRepository) {
        this.mapper = configuracaoEntityMapper;
        this.repository = configuracaoRepository;
    }


    @Override
    public Configuracao criarConfiguracao(Configuracao configuracao) {
        ConfiguracaoEntity entity = mapper.toEntity(configuracao);
        repository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public List<Configuracao> listarConfiguracao() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> listarEmailsConfiguracao() {
        return List.of();
    }

    @Override
    public List<Integer> listarTempoParaNotificacaoDeValidadeConfiguracao() {
        return List.of();
    }

    @Override
    public Configuracao deletarEmailConfiguracao(Long indice, String email) {
        return null;
    }

    @Override
    public Configuracao alterarConfiguracao(Configuracao configuracao) {
        ConfiguracaoEntity entity = new ConfiguracaoEntity(configuracao.getEmailsParaNotificacao(), configuracao.getTempoParaNotificacaoDeValidade());
        repository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public Configuracao alterarEmailConfiguracao(Long indice, String email) {
        return null;
    }

    @Override
    public Configuracao alterarTempoParaNotificacaoDeValidadeConfiguracao(Long indice, Integer dias) {
        return null;
    }
}
