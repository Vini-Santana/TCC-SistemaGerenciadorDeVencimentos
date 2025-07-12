package br.com.projetoTCC.infra.controller.BaseDeDadosProduto;

import br.com.projetoTCC.application.usecases.BaseDeDadosProduto.AlterarBaseDeDadosProduto;
import br.com.projetoTCC.application.usecases.BaseDeDadosProduto.CriarBaseDeDadosProduto;
import br.com.projetoTCC.application.usecases.BaseDeDadosProduto.DeletarBaseDeDadosProduto;
import br.com.projetoTCC.application.usecases.BaseDeDadosProduto.ListarBaseDeDadosProduto;
import br.com.projetoTCC.domain.entities.BaseDeDadosProduto.BaseDeDadosProduto;
import br.com.projetoTCC.infra.controller.Produto.ProdutoDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/baseDeDadosProdutos")
public class BaseDeDadosProdutoController {

    private final CriarBaseDeDadosProduto criarBaseDeDadosProduto;
    private final ListarBaseDeDadosProduto listarBaseDeDadosProduto;
    private final DeletarBaseDeDadosProduto deletarBaseDeDadosProduto;
    private final AlterarBaseDeDadosProduto alterarBaseDeDadosProduto;

    public BaseDeDadosProdutoController(CriarBaseDeDadosProduto criarBaseDeDadosProduto, ListarBaseDeDadosProduto listarBaseDeDadosProduto, DeletarBaseDeDadosProduto deletarBaseDeDadosProduto, AlterarBaseDeDadosProduto alterarBaseDeDadosProduto) {
        this.criarBaseDeDadosProduto = criarBaseDeDadosProduto;
        this.listarBaseDeDadosProduto = listarBaseDeDadosProduto;
        this.deletarBaseDeDadosProduto = deletarBaseDeDadosProduto;
        this.alterarBaseDeDadosProduto = alterarBaseDeDadosProduto;
    }


    @PostMapping
    public ResponseEntity<BaseDeDadosProdutoDTO> cadastrarBaseDeDadosProduto(@RequestBody @Valid BaseDeDadosProdutoDTO dto){
        criarBaseDeDadosProduto.criarBaseDeDadosProduto(new BaseDeDadosProduto(dto.nomeProduto(), dto.codigo(), dto.codigoBarras()));
        return ResponseEntity.status(HttpStatus.OK).body(new BaseDeDadosProdutoDTO(dto.nomeProduto(), dto.codigo(), dto.codigoBarras()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BaseDeDadosProdutoDTO> alterarBaseDeDadosProduto (@PathVariable Long id, @RequestBody BaseDeDadosProdutoDTO dto){
        BaseDeDadosProduto produtoSalvo = alterarBaseDeDadosProduto.alteraBaseDeDadosProduto(id, new BaseDeDadosProduto(dto.nomeProduto(), dto.codigo(), dto.codigoBarras()));

        return ResponseEntity.ok(new BaseDeDadosProdutoDTO(produtoSalvo.getNomeProduto(), produtoSalvo.getCodigo(), produtoSalvo.getCodigoBarras()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseDeDadosProdutoDTO> deletarBaseDeDadosProduto(@PathVariable Long id, @RequestBody BaseDeDadosProdutoDTO dto){
        deletarBaseDeDadosProduto.deletarBaseDeDadosProduto(id, new BaseDeDadosProduto(dto.nomeProduto(), dto.codigo(), dto.codigoBarras()));
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<BaseDeDadosProdutoDTO>> listarTodosBaseDeDadosProduto(){
        return ResponseEntity.ok(listarBaseDeDadosProduto.listarTodosBaseDeDadosProduto().stream()
                .map(p -> new BaseDeDadosProdutoDTO(p.getNomeProduto(), p.getCodigo(), p.getCodigoBarras())) //para cada usuário encontrado, faça algo (toDomain)
                .collect(Collectors.toList()));
    }

    @GetMapping("/buscarPor")
    public ResponseEntity<List<BaseDeDadosProdutoDTO>> listarBaseDeDadosProdutoPorFiltro(@RequestParam(required = false) String codigo, @RequestParam(required = false) String codigobarras) {
        if (codigo != null && !codigo.isBlank()) {
            return ResponseEntity.ok(listarBaseDeDadosProduto.listarBaseDeDadosProdutoPorCodigo(codigo).stream()
                    .map(p -> new BaseDeDadosProdutoDTO(p.getNomeProduto(), p.getCodigo(), p.getCodigoBarras())) //para cada usuário encontrado, faça algo (toDomain)
                    .collect(Collectors.toList()));

        } else if (codigobarras != null && !codigobarras.isBlank()) {
            return ResponseEntity.ok(listarBaseDeDadosProduto.listarBaseDeDadosProdutoPorCodigoBarras(codigobarras).stream()
                    .map(p -> new BaseDeDadosProdutoDTO(p.getNomeProduto(), p.getCodigo(), p.getCodigoBarras())) //para cada usuário encontrado, faça algo (toDomain)
                    .collect(Collectors.toList()));
        }else{
            return ResponseEntity.ok(listarBaseDeDadosProduto.listarTodosBaseDeDadosProduto().stream()
                    .map(p -> new BaseDeDadosProdutoDTO(p.getNomeProduto(), p.getCodigo(), p.getCodigoBarras())) //para cada usuário encontrado, faça algo (toDomain)
                    .collect(Collectors.toList()));
        }

    }
}
