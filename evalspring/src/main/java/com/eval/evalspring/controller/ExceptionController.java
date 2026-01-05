package com.eval.evalspring.controller;

import com.eval.evalspring.exception.CategorieNotFoundException;
import com.eval.evalspring.exception.ProduitNotFoundException;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionController {

    // Gestion de l'erreur Produit non trouvé
    @ExceptionHandler(ProduitNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleProduitNotFoundException(ProduitNotFoundException ex)
    {
        Map<String, String> response = new HashMap<>();
        response.put("Error", ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    // Gestion de l'erreur Categorie non trouvé
    @ExceptionHandler(CategorieNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleCategorieNotFoundException(CategorieNotFoundException ex)
    {
        Map<String , String> response = new HashMap<>();
        response.put("Error", ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }

    // Gestion des erreurs de doublon
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> handleRuntimeException(RuntimeException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("Error", ex.getMessage());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST) // Code 400
                .body(response);
    }
}
