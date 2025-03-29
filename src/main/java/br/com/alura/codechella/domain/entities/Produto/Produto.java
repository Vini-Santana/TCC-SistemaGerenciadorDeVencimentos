package br.com.alura.codechella.domain.entities.Produto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Produto {

    private String nome;
    private String codigo;
    private String codInterno;
    private LocalDate validade;
    private String lote;

    public Produto(String nome, String codigo, String codInterno, LocalDate validade, String lote) {
        this.nome = nome;
        this.codigo = codigo;
        this.codInterno = codInterno;
        this.validade = validade;
        this.lote = lote;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodInterno() {
        return codInterno;
    }

    public void setCodInterno(String codInterno) {
        this.codInterno = codInterno;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }
}
