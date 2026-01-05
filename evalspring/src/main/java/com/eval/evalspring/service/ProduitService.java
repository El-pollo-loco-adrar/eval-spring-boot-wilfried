package com.eval.evalspring.service;

import com.eval.evalspring.exception.ProduitNotFoundException;
import com.eval.evalspring.model.Produit;
import com.eval.evalspring.repository.ProduitRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProduitService {

    private ProduitRepository produitRepository;

    //Ajouter un produit
    public Produit ajouterUnProduit(Produit produit)
    {
        if(produitRepository.findByNom(produit.getNom()).isPresent())
        {
            throw new RuntimeException("Le produit existe déjà");
        }
        return produitRepository.save(produit);
    }

    //Récupérer la liste de tous les produits
    public List<Produit> recupererProduits()
    {
        return (List<Produit>) produitRepository.findAll();
    }

    //Récupérer un produit par son ID
    public Produit recupererProduitParId(Integer id)
    {
        return produitRepository.findById(id)
                .orElseThrow(() -> new ProduitNotFoundException("Erreur : Le produit avec l'id " + id +" n'existe pas"));
    }
}
