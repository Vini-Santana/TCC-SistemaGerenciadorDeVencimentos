package br.com.alura.codechella.infra.controller.Produto;

import br.com.alura.codechella.application.usecases.Produto.CriarProduto;
import br.com.alura.codechella.application.usecases.Produto.ListarProduto;
import br.com.alura.codechella.domain.entities.Produto.Produto;
import br.com.alura.codechella.infra.controller.GlobalExceptionHandler;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    private final CriarProduto criarProduto;
    private final ListarProduto listarProduto;

    public ProdutoController(CriarProduto criarProduto, ListarProduto listarProduto) {
        this.criarProduto = criarProduto;
        this.listarProduto = listarProduto;
    }

    @PostMapping
    public ProdutoDTO cadastrarProduto(@RequestBody@Valid ProdutoDTO dto){
            Produto produtoSalvo = criarProduto.criarproduto(new Produto(dto.nomeProduto(), dto.codigo(), dto.quantidade(), dto.validade(), dto.observacoes()));

            return new ProdutoDTO(produtoSalvo.getNomeProduto(), produtoSalvo.getCodigo(), produtoSalvo.getQuantidade(), produtoSalvo.getValidade(), produtoSalvo.getObservacoes());
    }

    @GetMapping
    public List<ProdutoDTO> listarProdutos(){
        return listarProduto.listarProdutos().stream()
                .map(p -> new ProdutoDTO(p.getNomeProduto(), p.getCodigo(), p.getQuantidade(), p.getValidade(), p.getObservacoes())) //para cada usuário encontrado, faça algo (toDomain)
                .collect(Collectors.toList());
    }
}
