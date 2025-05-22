package br.com.projetoTCC.domain.exceptions;

public class BaseDeDadosProdutoNotFoundException extends RuntimeException {
    public BaseDeDadosProdutoNotFoundException(Long id) {

        super("BaseDeDadosProduto com id " + id + " não encontrado.");
    }
}