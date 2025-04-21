package org.example.bootrestapi.controller;

import org.example.bootrestapi.model.entity.Recipe;
import org.example.bootrestapi.service.RecipeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public List<Recipe> getAllRecipes() {
        Recipe recipe = new Recipe();
        recipe.setName("커리");
        recipe.setDescription("맛있는 커리");
        recipeService.save(new Recipe());
        return recipeService.findAll();
    }
}
