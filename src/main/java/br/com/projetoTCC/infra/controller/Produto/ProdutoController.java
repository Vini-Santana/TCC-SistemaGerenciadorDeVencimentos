package br.com.projetoTCC.infra.controller.Produto;

import br.com.projetoTCC.application.usecases.Produto.AlterarProduto;
import br.com.projetoTCC.application.usecases.Produto.CriarProduto;
import br.com.projetoTCC.application.usecases.Produto.DeletarProduto;
import br.com.projetoTCC.application.usecases.Produto.ListarProduto;
import br.com.projetoTCC.domain.entities.Produto.Produto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    private final CriarProduto criarProduto;
    private final ListarProduto listarProduto;
    private final AlterarProduto alterarProduto;
    private final DeletarProduto deletarProduto;

    public ProdutoController(CriarProduto criarProduto, ListarProduto listarProduto, AlterarProduto alterarProduto, DeletarProduto deletarProduto) {
        this.criarProduto = criarProduto;
        this.listarProduto = listarProduto;
        this.alterarProduto = alterarProduto;
        this.deletarProduto = deletarProduto;
    }

    @PostMapping
    public ResponseEntity<ProdutoDTO> cadastrarProduto(@RequestBody@Valid ProdutoDTO dto){
            Produto produtoSalvo = criarProduto.criarproduto(new Produto(dto.nomeProduto(), dto.codigo(), dto.quantidade(), dto.validade(), dto.observacoes(), dto.lote(), dto.ultimaModificacao()));

            return ResponseEntity.status(HttpStatus.OK).body(new ProdutoDTO(produtoSalvo.getNomeProduto(), produtoSalvo.getCodigo(), produtoSalvo.getQuantidade(), produtoSalvo.getValidade(), produtoSalvo.getObservacoes(), produtoSalvo.getUltimaModificacao(), produtoSalvo.getLote()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> alterarProduto (@PathVariable Long id, @RequestBody ProdutoDTO dto){
        Produto produtoSalvo = alterarProduto.alteraProduto(id, new Produto(dto.nomeProduto(), dto.codigo(), dto.quantidade(), dto.validade(), dto.observacoes(), dto.lote(), dto.ultimaModificacao()));

        return ResponseEntity.ok(new ProdutoDTO(produtoSalvo.getNomeProduto(), produtoSalvo.getCodigo(), produtoSalvo.getQuantidade(), produtoSalvo.getValidade(), produtoSalvo.getObservacoes(),produtoSalvo.getUltimaModificacao(), produtoSalvo.getLote()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProdutoDTO> deletarProduto(@PathVariable Long id, @RequestBody ProdutoDTO dto){
        deletarProduto.deletarProduto(id, new Produto(dto.nomeProduto(), dto.codigo(), dto.quantidade(), dto.validade(), dto.observacoes(), dto.lote(), dto.ultimaModificacao()));

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> listarTodosProdutos(){
        return ResponseEntity.ok(listarProduto.listarTodosProduto().stream()
                .map(p -> new ProdutoDTO(p.getNomeProduto(), p.getCodigo(), p.getQuantidade(), p.getValidade(), p.getObservacoes(), p.getUltimaModificacao(), p.getLote())) //para cada usuário encontrado, faça algo (toDomain)
                .collect(Collectors.toList()));
    }
    @GetMapping("/comFiltro")
    public ResponseEntity<List<ProdutoDTO>>  listarTodosProdutosPorNome(@RequestParam(required = false) String nomeProduto, @RequestParam(required = false) String codigo, @RequestParam(required = false) Integer quantidade, @RequestParam(required = false)LocalDate validade, @RequestParam(required = false)Long id){
        if (nomeProduto != null && !nomeProduto.isBlank()){
            return ResponseEntity.ok(listarProduto.listarProdutoPorNome(nomeProduto).stream()
                    .map(p -> new ProdutoDTO(p.getNomeProduto(), p.getCodigo(), p.getQuantidade(), p.getValidade(), p.getObservacoes(), p.getUltimaModificacao(), p.getLote())) //para cada usuário encontrado, faça algo (toDomain)
                    .collect(Collectors.toList()));

        }else if (codigo != null && !codigo.isBlank()){
            return ResponseEntity.ok(listarProduto.listarProdutoPorCodigo(codigo).stream()
                    .map(p -> new ProdutoDTO(p.getNomeProduto(), p.getCodigo(), p.getQuantidade(), p.getValidade(), p.getObservacoes(), p.getUltimaModificacao(), p.getLote())) //para cada usuário encontrado, faça algo (toDomain)
                    .collect(Collectors.toList()));
        }else if (quantidade != null){
            return ResponseEntity.ok(listarProduto.listarProdutoPorQuantidade(quantidade).stream()
                    .map(p -> new ProdutoDTO(p.getNomeProduto(), p.getCodigo(), p.getQuantidade(), p.getValidade(), p.getObservacoes(), p.getUltimaModificacao(), p.getLote())) //para cada usuário encontrado, faça algo (toDomain)
                    .collect(Collectors.toList()));
        }else if (validade != null){
            return ResponseEntity.ok(listarProduto.listarProdutoPorValidade(validade).stream()
                    .map(p -> new ProdutoDTO(p.getNomeProduto(), p.getCodigo(), p.getQuantidade(), p.getValidade(), p.getObservacoes(), p.getUltimaModificacao(), p.getLote())) //para cada usuário encontrado, faça algo (toDomain)
                    .collect(Collectors.toList()));
        }else if (id != null){
            Produto produto = listarProduto.listarProdutoPorId(id);
            ProdutoDTO dto = new ProdutoDTO(produto.getNomeProduto(), produto.getCodigo(), produto.getQuantidade(), produto.getValidade(), produto.getObservacoes(), produto.getUltimaModificacao(), produto.getLote());
            return ResponseEntity.ok(List.of(dto));
        }
        else{
            return ResponseEntity.ok(listarProduto.listarTodosProduto().stream()
                    .map(p -> new ProdutoDTO(p.getNomeProduto(), p.getCodigo(), p.getQuantidade(), p.getValidade(), p.getObservacoes(), p.getUltimaModificacao(), p.getLote())) //para cada usuário encontrado, faça algo (toDomain)
                    .collect(Collectors.toList()));
        }
    }
}
