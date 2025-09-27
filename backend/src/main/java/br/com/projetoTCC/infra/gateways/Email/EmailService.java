package br.com.projetoTCC.infra.gateways.Email;

import br.com.projetoTCC.application.gateways.RepositorioDeEmailsConfiguracao;
import br.com.projetoTCC.domain.entities.Configuracao.Email.EmailsConfiguracao;
import br.com.projetoTCC.infra.controller.Email.EmailDTO;
import br.com.projetoTCC.infra.gateways.Configuracao.Email.EmailsConfiguracaoEntityMapper;
import br.com.projetoTCC.infra.persistence.Configuracao.Email.EmailsConfiguracaoRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailService {
    private final JavaMailSender mailSender;
    private final EmailsConfiguracaoRepository configuracaoRepository;
    private final EmailsConfiguracaoEntityMapper mapper;
    private final RepositorioDeEmailsConfiguracao repositorioDeEmailsConfiguracao;


    public EmailService(JavaMailSender mailSender, EmailsConfiguracaoRepository configuracaoRepository, EmailsConfiguracaoEntityMapper mapper, RepositorioDeEmailsConfiguracao repositorioDeEmailsConfiguracao) {
        this.mailSender = mailSender;
        this.configuracaoRepository = configuracaoRepository;
        this.mapper = mapper;
        this.repositorioDeEmailsConfiguracao = repositorioDeEmailsConfiguracao;
    }

    public String EnvialEmail(EmailDTO emailDTO) {
        try {
            var entity = configuracaoRepository.findTopByOrderByIdAsc();
            if (entity == null) {
                return "Nenhuma configuração encontrada.";
            }

            EmailsConfiguracao configuracao = mapper.toDomain(entity);
            List<EmailsConfiguracao> emailsConfiguracao = repositorioDeEmailsConfiguracao.listarEmailsConfiguracao();
            if (configuracao.getEmailsParaNotificacao().isEmpty()) {
                return "Nenhum e-mail configurado para notificação.";
            }

            var message = new SimpleMailMessage();
            for (EmailsConfiguracao email : emailsConfiguracao){
                message.setTo(email.getEmailsParaNotificacao());
                message.setSubject(emailDTO.subject());
                message.setText(emailDTO.body());
                mailSender.send(message);

            }

            return "Email enviado com sucesso";

        } catch (Exception e) {
            return "Erro ao enviar emailDTO: " + e.getLocalizedMessage();
        }
    }
}