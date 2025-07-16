package br.com.projetoTCC.infra.controller.Configuracao;

import br.com.projetoTCC.application.usecases.Configuracao.AlterarConfiguracao;
import br.com.projetoTCC.application.usecases.Configuracao.CriarConfiguracao;
import br.com.projetoTCC.application.usecases.Configuracao.ListarConfiguracao;
import br.com.projetoTCC.domain.entities.BaseDeDadosProduto.BaseDeDadosProduto;
import br.com.projetoTCC.domain.entities.Conficuracao.Configuracao;
import br.com.projetoTCC.infra.controller.BaseDeDadosProduto.BaseDeDadosProdutoDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/config")
public class ConfiguracaoController {

    private final ListarConfiguracao listarConfiguracao;
    private final AlterarConfiguracao alterarConfiguracao;
    private final CriarConfiguracao criarConfiguracao;

    public ConfiguracaoController(ListarConfiguracao listarConfiguracao, AlterarConfiguracao alterarConfiguracao, CriarConfiguracao criarConfiguracao) {
        this.listarConfiguracao = listarConfiguracao;
        this.alterarConfiguracao = alterarConfiguracao;
        this.criarConfiguracao = criarConfiguracao;
    }

    @PostMapping
    public ResponseEntity<ConfiguracaoDTO> cadastrarConfiguracao(@RequestBody @Valid ConfiguracaoDTO dto){
        Configuracao configuracao = criarConfiguracao.criarConfiguracao(new Configuracao(dto.emailsParaNotificacao(), dto.tempoParaNotificacaoDeValidade()));
        return ResponseEntity.status(HttpStatus.OK).body(new ConfiguracaoDTO(configuracao.getEmailsParaNotificacao(), configuracao.getTempoParaNotificacaoDeValidade()));
    }

    @GetMapping
    public ResponseEntity<List<ConfiguracaoDTO>> listarConfiguracao(){
        return ResponseEntity.ok(listarConfiguracao.listarConfiguracao().stream()
                .map(p -> new ConfiguracaoDTO(p.getEmailsParaNotificacao(), p.getTempoParaNotificacaoDeValidade()))
                .collect(Collectors.toList()));
    }

    @PutMapping
    public ResponseEntity<ConfiguracaoDTO> alterarConfiguracao (@RequestBody ConfiguracaoDTO dto){
        Configuracao configuracaoSalva = alterarConfiguracao.alterarConfiguracao(new Configuracao(dto.emailsParaNotificacao(), dto.tempoParaNotificacaoDeValidade()));

        return ResponseEntity.ok(new ConfiguracaoDTO(configuracaoSalva.getEmailsParaNotificacao(), configuracaoSalva.getTempoParaNotificacaoDeValidade()));
    }
}
