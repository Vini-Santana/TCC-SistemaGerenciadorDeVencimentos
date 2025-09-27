package br.com.projetoTCC.infra.controller;

import br.com.projetoTCC.domain.exceptions.ProdutoNotFoundExceptionId;
import br.com.projetoTCC.domain.exceptions.TipoTempoBadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProdutoNotFoundExceptionId.class)
    public ResponseEntity<String> handleProdutoNotFound(ProdutoNotFoundExceptionId ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(TipoTempoBadRequestException.class)
    public ResponseEntity<String> handleTipoTempoBadRequest(TipoTempoBadRequestException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<String> duplicateEntry(Exception ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O valor informado já está configurado.");
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String> handleGenericException(Exception ex) {
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foram informados todos os parâmetros");
//    }
}

