package br.com.projetoTCC.domain.exceptions;

public class TipoTempoBadRequestException extends RuntimeException {

    public TipoTempoBadRequestException(String tipo) {
        super("Tipo de tempo inválido: "+tipo+ ". Deve ser 'TempoAVencer' ou 'NotificacoesDeValidade'.");
    }
}