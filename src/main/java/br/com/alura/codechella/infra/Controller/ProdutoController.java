package br.com.alura.codechella.infra.Controller;

import br.com.alura.codechella.application.usecases.CriarProduto;
import br.com.alura.codechella.domain.entities.Produto.Produto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    private final CriarProduto criarProduto;

    public ProdutoController(CriarProduto criarProduto) {
        this.criarProduto = criarProduto;
    }

    @PostMapping
    public ProdutoDTO cadastrarProduto(@RequestBody ProdutoDTO dto) throws Throwable {
            Produto produtoSalvo = criarProduto.criarproduto(new Produto(dto.nome(), dto.codigo(), dto.codInterno(), dto.validade(), dto.lote()));

            return new ProdutoDTO(produtoSalvo.getNome(), produtoSalvo.getCodigo(), produtoSalvo.getCodInterno(), produtoSalvo.getValidade(), produtoSalvo.getLote());

    }
}
