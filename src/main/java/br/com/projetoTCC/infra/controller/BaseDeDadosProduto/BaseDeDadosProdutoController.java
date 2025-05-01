package br.com.projetoTCC.infra.controller.BaseDeDadosProduto;

import br.com.projetoTCC.application.usecases.BaseDeDadosProduto.CriarBaseDeDadosProduto;
import br.com.projetoTCC.application.usecases.BaseDeDadosProduto.ListarBaseDeDadosProduto;
import br.com.projetoTCC.domain.entities.BaseDeDadosProduto.BaseDeDadosProduto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/baseDeDadosProduto")
public class BaseDeDadosProdutoController {

    private final CriarBaseDeDadosProduto criarBaseDeDadosProduto;
    private final ListarBaseDeDadosProduto listarBaseDeDadosProduto;

    public BaseDeDadosProdutoController(CriarBaseDeDadosProduto criarBaseDeDadosProduto, ListarBaseDeDadosProduto listarBaseDeDadosProduto) {
        this.criarBaseDeDadosProduto = criarBaseDeDadosProduto;
        this.listarBaseDeDadosProduto = listarBaseDeDadosProduto;
    }


    @PostMapping
    public BaseDeDadosProdutoDTO cadastrarBaseDeDadosProduto(@RequestBody @Valid BaseDeDadosProdutoDTO dto){
        criarBaseDeDadosProduto.criarBaseDeDadosProduto(new BaseDeDadosProduto(dto.nomeProduto(), dto.codigo()));
//        return new BaseDeDadosProdutoDTO(dto.nomeProduto(), dto.codigo());
        return dto;
    }

    @GetMapping
    public List<BaseDeDadosProdutoDTO> listarBaseDeDadosProdutoDTO(){
        return listarBaseDeDadosProduto.listarBaseDeDadosProduto().stream()
                .map(b -> new BaseDeDadosProdutoDTO(b.getNomeProduto(), b.getCodigo()))
                .collect(Collectors.toList());

    }
}
