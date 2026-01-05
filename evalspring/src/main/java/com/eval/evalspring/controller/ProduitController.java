package com.eval.evalspring.controller;

import com.eval.evalspring.model.Produit;
import com.eval.evalspring.service.ProduitService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProduitController {

    private ProduitService produitService;

    // retourner un JSON en GET avec le produit et sa categorie par son ID code status 200
    @GetMapping("/produit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Produit getProduitById(@PathVariable Integer id)
    {
        return produitService.recupererProduitParId(id);
    }

    //Retourner un JSON en GET avec tous les produits (Categorie incluse) code status 200,
    @GetMapping("/produits")
    @ResponseStatus(HttpStatus.OK)
    public List<Produit> getAllProduits()
    {
        return produitService.recupererProduits();
    }

    // Ajouter un produit en POST (JSON produit en entrée) code status 201
    @PostMapping("/produit")
    @ResponseStatus(HttpStatus.CREATED)
    public Produit createProduit(@Valid @RequestBody Produit produit)
    {
        return produitService.ajouterUnProduit(produit);
    }
}
