package org.example.bootrestapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.example.bootrestapi.model.dto.RecipeDTO;
import org.example.bootrestapi.model.entity.Recipe;
import org.example.bootrestapi.service.RecipeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public ResponseEntity<List<Recipe>> getAllRecipes() {
//        return recipeService.findAll();
        return new ResponseEntity<>(recipeService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Recipe> addRecipe(@RequestBody RecipeDTO dto) throws BadRequestException {
        try{
            Recipe recipe = new Recipe();
            recipe.setName(dto.name());
            recipe.setDescription(dto.description());
            return new ResponseEntity<>(recipeService.save(recipe), HttpStatus.CREATED);
        } catch (BadRequestException e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
