package org.example.bootrestapi.service;

import org.example.bootrestapi.model.entity.Recipe;

import java.util.List;

public interface RecipeService {
    List<Recipe> findAll();
    Recipe save(Recipe recipe); //JPA
}
