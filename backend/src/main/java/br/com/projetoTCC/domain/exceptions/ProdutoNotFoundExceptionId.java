package br.com.projetoTCC.domain.exceptions;

public class ProdutoNotFoundExceptionId extends RuntimeException {

    public ProdutoNotFoundExceptionId (Long id) {
        super("Produto com id " + id + " não encontrado.");
    }
}