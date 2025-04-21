package org.example.bootrestapi.service;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.example.bootrestapi.model.entity.Recipe;
import org.example.bootrestapi.repository.RecipeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    @Override
    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe save(Recipe recipe) throws BadRequestException {
        if (recipe.getName().isEmpty()) {
            throw new BadRequestException("이름이 없습니다.");
        }
        if (recipe.getDescription().isEmpty()) {
            throw new BadRequestException("레시피가 없습니다.");
        }
        return recipeRepository.save(recipe);
    }
}
