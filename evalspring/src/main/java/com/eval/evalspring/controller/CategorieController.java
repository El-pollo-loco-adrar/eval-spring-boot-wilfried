package com.eval.evalspring.controller;

import com.eval.evalspring.model.Categorie;
import com.eval.evalspring.service.CategorieService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class CategorieController {

    private CategorieService categorieService;

    // Ajouter une categorie en POST (JSON categorie en entrée) code status 201.
    @PostMapping("/categorie")
    @ResponseStatus(HttpStatus.CREATED)
    public Categorie createCategorie(@Valid @RequestBody Categorie categorie)
    {
        return categorieService.ajouterUneCategorie(categorie);
    }
}
