package org.example.bootrestapi.service;

import lombok.RequiredArgsConstructor;
import org.example.bootrestapi.model.entity.Recipe;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {


    private final RecipeService recipeService;

    @Override
    public List<Recipe> findAll() {
        return recipeService.findAll();
    }

    @Override
    public Recipe save(Recipe recipe) {
        return recipeService.save(recipe);
    }
}
