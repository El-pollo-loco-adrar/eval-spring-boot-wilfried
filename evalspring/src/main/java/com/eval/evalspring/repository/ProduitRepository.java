package com.eval.evalspring.repository;

import com.eval.evalspring.model.Produit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProduitRepository extends CrudRepository<Produit, Integer> 
{
    Optional<Object> findByNom(String nom);
}
