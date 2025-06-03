package br.com.projetoTCC.domain.entities.Produto;

import java.time.LocalDate;

public class Produto {

    private String nomeProduto;
    private String codigo;
    private Integer quantidade;
    private LocalDate validade;
    private String observacoes;
    private String lote;
    private LocalDate ultimaModificacao;

    public Produto(String nomeProduto, String codigo, Integer quantidade, LocalDate validade, String observacoes, String lote, LocalDate ultimaModificacao) {
        this.nomeProduto = nomeProduto;
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.validade = validade;
        this.observacoes = observacoes;
        this.lote = lote;
        this.ultimaModificacao = ultimaModificacao;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public LocalDate getUltimaModificacao() {
        return ultimaModificacao;
    }

    public void setUltimaModificacao(LocalDate ultimaModificacao) {
        this.ultimaModificacao = ultimaModificacao;
    }
}