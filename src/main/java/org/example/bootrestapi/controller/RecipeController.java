package org.example.bootrestapi.controller;

import org.example.bootrestapi.model.dto.RecipeDTO;
import org.example.bootrestapi.model.entity.Recipe;
import org.example.bootrestapi.service.RecipeService;
import org.springframework.web.bind.annotation.*;

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

        return recipeService.findAll();
    }

    @PostMapping
    public Recipe addRecipe(@RequestBody RecipeDTO dto) {
        Recipe recipe = new Recipe();
        recipe.setName(dto.name());
        recipe.setDescription(dto.description());
        return recipeService.save(recipe);
    }
}
