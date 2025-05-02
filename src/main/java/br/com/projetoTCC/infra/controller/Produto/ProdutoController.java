package br.com.projetoTCC.infra.controller.Produto;

import br.com.projetoTCC.application.usecases.Produto.AlterarProduto;
import br.com.projetoTCC.application.usecases.Produto.CriarProduto;
import br.com.projetoTCC.application.usecases.Produto.DeletarProduto;
import br.com.projetoTCC.application.usecases.Produto.ListarProduto;
import br.com.projetoTCC.domain.entities.Produto.Produto;
import br.com.projetoTCC.domain.exceptions.ProdutoNotFoundException;
import jakarta.validation.Valid;
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
    public ProdutoDTO cadastrarProduto(@RequestBody@Valid ProdutoDTO dto){
            Produto produtoSalvo = criarProduto.criarproduto(new Produto(dto.nomeProduto(), dto.codigo(), dto.quantidade(), dto.validade(), dto.observacoes()));

            return new ProdutoDTO(produtoSalvo.getNomeProduto(), produtoSalvo.getCodigo(), produtoSalvo.getQuantidade(), produtoSalvo.getValidade(), produtoSalvo.getObservacoes());
    }

    @PutMapping("/{id}")
    public ProdutoDTO alterarProduto (@PathVariable Long id, @RequestBody ProdutoDTO dto){
        Produto produtoSalvo  = alterarProduto.alteraProduto(id, new Produto(dto.nomeProduto(), dto.codigo(), dto.quantidade(), dto.validade(), dto.observacoes()));

        return new ProdutoDTO(produtoSalvo.getNomeProduto(), produtoSalvo.getCodigo(), produtoSalvo.getQuantidade(), produtoSalvo.getValidade(), produtoSalvo.getObservacoes());
    }

    @DeleteMapping("/{id}")
    public ProdutoDTO deletarProduto(@PathVariable Long id, @RequestBody ProdutoDTO dto){
        deletarProduto.deletarProduto(id, new Produto(dto.nomeProduto(), dto.codigo(), dto.quantidade(), dto.validade(), dto.observacoes()));
        Produto produtoSalvo  = new Produto(dto.nomeProduto(), dto.codigo(), dto.quantidade(), dto.validade(), dto.observacoes());

        return new ProdutoDTO(produtoSalvo.getNomeProduto(), produtoSalvo.getCodigo(), produtoSalvo.getQuantidade(), produtoSalvo.getValidade(), produtoSalvo.getObservacoes());
    }

    @GetMapping
    public List<ProdutoDTO> listarTodosProdutos(){
        return listarProduto.listarTodosProdutos().stream()
                .map(p -> new ProdutoDTO(p.getNomeProduto(), p.getCodigo(), p.getQuantidade(), p.getValidade(), p.getObservacoes())) //para cada usuário encontrado, faça algo (toDomain)
                .collect(Collectors.toList());
    }
    @GetMapping("/comFiltro")
    public List<ProdutoDTO> listarTodosProdutosPorNome(@RequestParam(required = false) String nomeProduto, @RequestParam(required = false) String codigo, @RequestParam(required = false) Integer quantidade, @RequestParam(required = false)LocalDate validade, @RequestParam(required = false)Long id){
        if (nomeProduto != null && !nomeProduto.isBlank()){
            return listarProduto.listarProdutoPorNome(nomeProduto).stream()
                .map(p -> new ProdutoDTO(p.getNomeProduto(), p.getCodigo(), p.getQuantidade(), p.getValidade(), p.getObservacoes()))
                .collect(Collectors.toList());

        }else if (codigo != null && !codigo.isBlank()){
                return listarProduto.listarProdutoPorCodigo(codigo).stream()
                    .map(p -> new ProdutoDTO(p.getNomeProduto(), p.getCodigo(), p.getQuantidade(), p.getValidade(), p.getObservacoes()))
                    .collect(Collectors.toList());
        }else if (quantidade != null){
            return listarProduto.listarProdutoPorQuantidade(quantidade).stream()
                    .map(p -> new ProdutoDTO(p.getNomeProduto(), p.getCodigo(), p.getQuantidade(), p.getValidade(), p.getObservacoes()))
                    .collect(Collectors.toList());
        }else if (validade != null){
            return listarProduto.listarProdutoPorValidade(validade).stream()
                    .map(p -> new ProdutoDTO(p.getNomeProduto(), p.getCodigo(), p.getQuantidade(), p.getValidade(), p.getObservacoes()))
                    .collect(Collectors.toList());
        }else if (id != null){
            Produto produto = listarProduto.listarProdutoPorId(id);
            ProdutoDTO dto = new ProdutoDTO(produto.getNomeProduto(), produto.getCodigo(), produto.getQuantidade(), produto.getValidade(), produto.getObservacoes());
            return List.of(dto);
        }
        else{
            return listarProduto.listarTodosProdutos().stream()
                    .map(p -> new ProdutoDTO(p.getNomeProduto(), p.getCodigo(), p.getQuantidade(), p.getValidade(), p.getObservacoes())) //para cada usuário encontrado, faça algo (toDomain)
                    .collect(Collectors.toList());
        }
    }
}
