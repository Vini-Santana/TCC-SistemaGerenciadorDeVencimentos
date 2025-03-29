package br.com.alura.codechella.domain.entities.Produto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class FabricaDeProduto {

    public Produto criaProduto(String nome, String codigo, String codInterno, LocalDate validade, String lote){
        Produto produto = new Produto(nome, codigo, codInterno,validade, lote);
        return produto;
    }

}
