package br.com.projetoTCC.domain.exceptions;

public class TempoParaNotificacaoNotFoundExceptionId extends RuntimeException {

    public TempoParaNotificacaoNotFoundExceptionId(Long id) {
        super("Tempo com id " + id + " não encontrado.");
    }
}