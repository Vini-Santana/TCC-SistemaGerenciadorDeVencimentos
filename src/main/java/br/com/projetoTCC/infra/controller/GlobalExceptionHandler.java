package br.com.projetoTCC.infra.controller;

import br.com.projetoTCC.domain.exceptions.ProdutoNotFoundExceptionId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProdutoNotFoundExceptionId.class)
    public ResponseEntity<String> handleProdutoNotFound(ProdutoNotFoundExceptionId ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foram informados todos os parâmetros: ");
    }
}

