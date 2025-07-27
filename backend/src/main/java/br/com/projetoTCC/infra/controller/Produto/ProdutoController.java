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

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produtos")
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
        Produto produtoSalvo = criarProduto.criarproduto(new Produto(dto.nomeProduto(), dto.codigo(), dto.quantidade(), dto.validade(), dto.observacoes(), dto.ultimaModificacao()));

        return ResponseEntity.status(HttpStatus.OK).body(new ProdutoDTO(produtoSalvo.getId(), produtoSalvo.getNomeProduto(), produtoSalvo.getCodigo(), produtoSalvo.getQuantidade(), produtoSalvo.getValidade(), produtoSalvo.getObservacoes(), produtoSalvo.getUltimaModificacao(), false));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> alterarProduto (@PathVariable Long id, @RequestBody ProdutoDTO dto){
        Produto produtoSalvo = alterarProduto.alteraProduto(id, new Produto(dto.nomeProduto(), dto.codigo(), dto.quantidade(), dto.validade(), dto.observacoes(), dto.ultimaModificacao()));

        return ResponseEntity.ok(new ProdutoDTO(produtoSalvo.getId(), produtoSalvo.getNomeProduto(), produtoSalvo.getCodigo(), produtoSalvo.getQuantidade(), produtoSalvo.getValidade(), produtoSalvo.getObservacoes(), produtoSalvo.getUltimaModificacao(), false));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProdutoDTO> deletarProduto(@PathVariable Long id, @RequestBody ProdutoDTO dto){
        deletarProduto.deletarProduto(id, new Produto(dto.nomeProduto(), dto.codigo(), dto.quantidade(), dto.validade(), dto.observacoes(), dto.ultimaModificacao()));

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> listarTodosProdutos(){

        return ResponseEntity.ok(listarProduto.listarTodosProduto().stream()
                .map(p -> new ProdutoDTO(p.getId(), p.getNomeProduto(), p.getCodigo(), p.getQuantidade(), p.getValidade(), p.getObservacoes(), p.getUltimaModificacao(), listarProduto.isAVencer(p)))
                .collect(Collectors.toList()));
    }
}
