package br.com.projetoTCC.infra.controller.Email;

import br.com.projetoTCC.infra.gateways.Email.EmailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public String sendEmail(@RequestBody EmailDTO emailDTO){
        return emailService.EnvialEmail(emailDTO);

    }
}
