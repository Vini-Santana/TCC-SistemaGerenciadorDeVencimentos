package br.com.projetoTCC.infra.controller.Configuracao.Email;

import br.com.projetoTCC.application.usecases.configuracao.Email.AlterarEmailsConfiguracao;
import br.com.projetoTCC.application.usecases.configuracao.Email.CriarEmailsConfiguracao;
import br.com.projetoTCC.application.usecases.configuracao.Email.DeletarEmailsConfiguracao;
import br.com.projetoTCC.application.usecases.configuracao.Email.ListarEmailsConfiguracao;
import br.com.projetoTCC.domain.entities.Configuracao.Email.EmailsConfiguracao;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/config/email")
public class EmailsConfiguracaoController {

    private final ListarEmailsConfiguracao listarEmailsConfiguracao;
    private final AlterarEmailsConfiguracao alterarEmailsConfiguracao;
    private final CriarEmailsConfiguracao criarEmailsConfiguracao;
    private final DeletarEmailsConfiguracao deletarEmailsConfiguracao;

    public EmailsConfiguracaoController(ListarEmailsConfiguracao listarEmailsConfiguracao, AlterarEmailsConfiguracao alterarEmailsConfiguracao, CriarEmailsConfiguracao criarEmailsConfiguracao, DeletarEmailsConfiguracao deletarEmailsConfiguracao) {
        this.listarEmailsConfiguracao = listarEmailsConfiguracao;
        this.alterarEmailsConfiguracao = alterarEmailsConfiguracao;
        this.criarEmailsConfiguracao = criarEmailsConfiguracao;
        this.deletarEmailsConfiguracao = deletarEmailsConfiguracao;
    }


    @PostMapping
    public ResponseEntity<EmailsConfiguracaoDTO> cadastrarEmailsConfiguracao(@RequestBody @Valid EmailsConfiguracaoDTO dto){
        EmailsConfiguracao configuracao = criarEmailsConfiguracao.criarEmailConfiguracao(new EmailsConfiguracao(dto.emailsParaNotificacao()));
        return ResponseEntity.status(HttpStatus.OK).body(new EmailsConfiguracaoDTO(configuracao.getId(), configuracao.getEmailsParaNotificacao()));
    }

    @GetMapping
    public ResponseEntity<List<EmailsConfiguracaoDTO>> listarEmailsConfiguracao(){
        return ResponseEntity.ok(listarEmailsConfiguracao.listarEmailsConfiguracao().stream()
                .map(p -> new EmailsConfiguracaoDTO(p.getId(), p.getEmailsParaNotificacao()))
                .collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmailsConfiguracaoDTO> alterarEmailsConfiguracao (@PathVariable Long id, @RequestBody EmailsConfiguracaoDTO dto){
        EmailsConfiguracao email = alterarEmailsConfiguracao.alterarEmailConfiguracao(id, new EmailsConfiguracao(dto.emailsParaNotificacao()));

        return ResponseEntity.ok(new EmailsConfiguracaoDTO(email.getId(), email.getEmailsParaNotificacao()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EmailsConfiguracaoDTO> deletarEmailsConfiguracao(@PathVariable Long id, @RequestBody EmailsConfiguracaoDTO dto){
        deletarEmailsConfiguracao.deletarEmailConfiguracao(id, new EmailsConfiguracao(dto.emailsParaNotificacao())
    );
        return ResponseEntity.ok().build();
    }
}
