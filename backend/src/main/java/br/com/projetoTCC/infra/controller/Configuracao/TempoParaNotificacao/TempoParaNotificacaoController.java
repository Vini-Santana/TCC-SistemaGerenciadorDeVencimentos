package br.com.projetoTCC.infra.controller.Configuracao.TempoParaNotificacao;

import br.com.projetoTCC.application.usecases.configuracao.TempoNotificacao.AlterarTempoParaNotificacaoConfiguracao;
import br.com.projetoTCC.application.usecases.configuracao.TempoNotificacao.CriarTempoParaNotificacaoConfiguracao;
import br.com.projetoTCC.application.usecases.configuracao.TempoNotificacao.DeletarTempoParaNotificacaoConfiguracao;
import br.com.projetoTCC.application.usecases.configuracao.TempoNotificacao.ListarTempoParaNotificacaoConfiguracao;
import br.com.projetoTCC.domain.entities.Configuracao.Email.EmailsConfiguracao;
import br.com.projetoTCC.domain.entities.Configuracao.TempoParaNotificacao.TempoParaNotificacaoConfiguracao;
import br.com.projetoTCC.domain.entities.Produto.Produto;
import br.com.projetoTCC.domain.exceptions.TipoTempoBadRequestException;
import br.com.projetoTCC.infra.controller.GlobalExceptionHandler;
import br.com.projetoTCC.infra.controller.Produto.ProdutoDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/config/tempo-notificacao")
public class TempoParaNotificacaoController {

    private final ListarTempoParaNotificacaoConfiguracao listarTempoParaNotificacaoConfiguracao;
    private final AlterarTempoParaNotificacaoConfiguracao alterarTempoParaNotificacaoConfiguracao;
    private final CriarTempoParaNotificacaoConfiguracao criarTempoParaNotificacaoConfiguracao;
    private final DeletarTempoParaNotificacaoConfiguracao deletarTempoParaNotificacaoConfiguracao;

    public TempoParaNotificacaoController(ListarTempoParaNotificacaoConfiguracao listarTempoParaNotificacaoConfiguracao, AlterarTempoParaNotificacaoConfiguracao alterarTempoParaNotificacaoConfiguracao, CriarTempoParaNotificacaoConfiguracao criarTempoParaNotificacaoConfiguracao, DeletarTempoParaNotificacaoConfiguracao deletarTempoParaNotificacaoConfiguracao) {
        this.listarTempoParaNotificacaoConfiguracao = listarTempoParaNotificacaoConfiguracao;
        this.alterarTempoParaNotificacaoConfiguracao = alterarTempoParaNotificacaoConfiguracao;
        this.criarTempoParaNotificacaoConfiguracao = criarTempoParaNotificacaoConfiguracao;
        this.deletarTempoParaNotificacaoConfiguracao = deletarTempoParaNotificacaoConfiguracao;
    }

    @PostMapping
    public ResponseEntity<TempoParaNotificacaoConfiguracaoDTO> cadastrarTempoConfiguracao(@RequestBody @Valid TempoParaNotificacaoConfiguracaoDTO dto){
        if (dto.tipoTempo().equals("TempoAVencer") || dto.tipoTempo().equals("NotificacoesDeValidade")) {
            TempoParaNotificacaoConfiguracao configuracao = criarTempoParaNotificacaoConfiguracao.criarTempoConfiguracao(new TempoParaNotificacaoConfiguracao(dto.tempoParaNotificacaoDeValidade(), dto.tipoTempo()));
            return ResponseEntity.status(HttpStatus.OK).body(new TempoParaNotificacaoConfiguracaoDTO(configuracao.getId(), configuracao.getTempoParaNotificacaoDeValidade(), configuracao.getTipoTempo()));
        }else {
            throw new TipoTempoBadRequestException(dto.tipoTempo());
        }
    }

    @GetMapping
    public ResponseEntity<List<TempoParaNotificacaoConfiguracaoDTO>> listarTempoConfiguracao(){
        return ResponseEntity.ok(listarTempoParaNotificacaoConfiguracao.listarTempoParaNotificacaoDeValidadeConfiguracao().stream()
                .map(p -> new TempoParaNotificacaoConfiguracaoDTO(p.getId(), p.getTempoParaNotificacaoDeValidade(), p.getTipoTempo()))
                .collect(Collectors.toList()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TempoParaNotificacaoConfiguracaoDTO> alterarTempoConfiguracao (@PathVariable Long id, @RequestBody TempoParaNotificacaoConfiguracaoDTO dto){
        TempoParaNotificacaoConfiguracao configuracaoSalva = alterarTempoParaNotificacaoConfiguracao.alterarConfiguracao(id, new TempoParaNotificacaoConfiguracao(dto.tempoParaNotificacaoDeValidade(), dto.tipoTempo()));

        return ResponseEntity.ok(new TempoParaNotificacaoConfiguracaoDTO(configuracaoSalva.getId(), configuracaoSalva.getTempoParaNotificacaoDeValidade(), configuracaoSalva.getTipoTempo()));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TempoParaNotificacaoConfiguracaoDTO> deletarEmailsConfiguracao(@PathVariable Long id, @RequestBody TempoParaNotificacaoConfiguracaoDTO dto){
        deletarTempoParaNotificacaoConfiguracao.deletarTempoConfiguracao(id, new TempoParaNotificacaoConfiguracao(dto.tempoParaNotificacaoDeValidade(), dto.tipoTempo())
        );
        return ResponseEntity.ok().build();
    }
}
