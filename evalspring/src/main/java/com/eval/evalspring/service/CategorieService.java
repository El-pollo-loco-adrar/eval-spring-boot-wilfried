package com.eval.evalspring.service;

import com.eval.evalspring.exception.CategorieNotFoundException;
import com.eval.evalspring.model.Categorie;
import com.eval.evalspring.repository.CategorieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategorieService {

    private CategorieRepository categorieRepository;

    //Ajouter une catégorie
    public Categorie ajouterUneCategorie(Categorie categorie)
    {
        if(categorieRepository.findByLibele(categorie.getLibele()).isPresent())
        {
            throw new RuntimeException("La catégorie existe déjà");
        }
        return categorieRepository.save(categorie);
    }

    //Récupérer la liste de toute les categories
    public List<Categorie> recupererCategories()
    {
        return (List<Categorie>) categorieRepository.findAll();
    }

    //Récupérer une catégori par son id
    public Categorie recupererCategorieParSonId(Integer id)
    {
        return categorieRepository.findById(id)
                .orElseThrow(() -> new CategorieNotFoundException("Erreur : La catégorie avec l'id " + id + " n'existe pas "));
    }
}
