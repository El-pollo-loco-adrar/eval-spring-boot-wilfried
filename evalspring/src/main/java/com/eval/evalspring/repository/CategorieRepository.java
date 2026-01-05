package com.eval.evalspring.repository;

import com.eval.evalspring.model.Categorie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategorieRepository extends CrudRepository<Categorie, Integer>
{
    Optional<Object> findByLibele(String libele);
}
