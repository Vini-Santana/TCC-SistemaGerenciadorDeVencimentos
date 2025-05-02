package br.com.projetoTCC.domain.exceptions;

public class ProdutoNotFoundException extends RuntimeException {
    public ProdutoNotFoundException(Long id) {
        super("Produto com id " + id + " não encontrado.");
    }
}