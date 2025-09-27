package br.com.projetoTCC.infra.gateways.Configuracao.Email;

import br.com.projetoTCC.application.gateways.RepositorioDeEmailsConfiguracao;
import br.com.projetoTCC.domain.entities.Configuracao.Email.EmailsConfiguracao;
import br.com.projetoTCC.infra.persistence.Configuracao.Email.EmailsConfiguracaoEntity;
import br.com.projetoTCC.infra.persistence.Configuracao.Email.EmailsConfiguracaoRepository;

import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeEmailsConfiguracaoJPA implements RepositorioDeEmailsConfiguracao {

    private final EmailsConfiguracaoEntityMapper mapper;
    private final EmailsConfiguracaoRepository repository;

    public RepositorioDeEmailsConfiguracaoJPA(EmailsConfiguracaoEntityMapper mapper, EmailsConfiguracaoRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public EmailsConfiguracao criarEmailConfiguracao(EmailsConfiguracao configuracao) {
        EmailsConfiguracaoEntity entity = mapper.toEntity(configuracao);
        repository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public List<EmailsConfiguracao> listarEmailsConfiguracao() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public EmailsConfiguracao deletarEmailConfiguracao(Long id, EmailsConfiguracao email) {
        repository.deleteById(id);
        return email;
    }

    @Override
    public EmailsConfiguracao alterarEmailConfiguracao(Long indice, EmailsConfiguracao email) {
        EmailsConfiguracaoEntity entity = new EmailsConfiguracaoEntity(indice, email.getEmailsParaNotificacao());
        repository.save(entity);
        return mapper.toDomain(entity);
    }

}
