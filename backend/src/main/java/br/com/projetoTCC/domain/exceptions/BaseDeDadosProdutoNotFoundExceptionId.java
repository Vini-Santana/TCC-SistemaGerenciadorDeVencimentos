package br.com.projetoTCC.domain.exceptions;

public class BaseDeDadosProdutoNotFoundExceptionId extends RuntimeException {
    public BaseDeDadosProdutoNotFoundExceptionId(Long id) {

        super("BaseDeDadosProduto com id " + id + " não encontrado.");
    }
}