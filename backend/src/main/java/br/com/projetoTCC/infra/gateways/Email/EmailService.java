package br.com.projetoTCC.infra.gateways.Email;

import br.com.projetoTCC.domain.entities.Conficuracao.Configuracao;
import br.com.projetoTCC.infra.controller.Email.EmailDTO;
import br.com.projetoTCC.infra.gateways.Configuracao.ConfiguracaoEntityMapper;
import br.com.projetoTCC.infra.persistence.Configuracao.ConfiguracaoRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final JavaMailSender mailSender;
    private final ConfiguracaoRepository configuracaoRepository;
    private final ConfiguracaoEntityMapper mapper;


    public EmailService(JavaMailSender mailSender, ConfiguracaoRepository configuracaoRepository, ConfiguracaoEntityMapper mapper) {
        this.mailSender = mailSender;
        this.configuracaoRepository = configuracaoRepository;
        this.mapper = mapper;
    }

    public String EnvialEmail(EmailDTO emailDTO) {
        try {
            var entity = configuracaoRepository.findTopByOrderByIdAsc();
            if (entity == null) {
                return "Nenhuma configuração encontrada.";
            }

            Configuracao configuracao = mapper.toDomain(entity);

            if (configuracao.getEmailsParaNotificacao().isEmpty()) {
                return "Nenhum e-mail configurado para notificação.";
            }

            var message = new SimpleMailMessage();
            message.setTo(configuracao.getEmailsParaNotificacao().toArray(new String[0]));
            message.setSubject(emailDTO.subject());
            message.setText(emailDTO.body());

            mailSender.send(message);
            return "Email enviado com sucesso";

        } catch (Exception e) {
            return "Erro ao enviar emailDTO: " + e.getLocalizedMessage();
        }
    }
}