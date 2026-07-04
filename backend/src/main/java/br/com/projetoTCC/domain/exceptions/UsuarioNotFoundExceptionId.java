package br.com.projetoTCC.domain.exceptions;

public class UsuarioNotFoundExceptionId extends RuntimeException {

    public UsuarioNotFoundExceptionId(String usuario) {
        super("Usuario " + usuario + " não encontrado.");
    }
}