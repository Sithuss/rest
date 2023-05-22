package com.example.recipesbookapi.controller;

import com.example.recipesbookapi.model.Recipe;
import com.example.recipesbookapi.service.RecipeService;
import jakarta.persistence.ElementCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;

    @GetMapping("/list-recipes")
    public ResponseEntity listRecipes() {
        return ResponseEntity.ok()
                .body(recipeService.findAllRecipe());
    }
    record RequestRecipe(String title, String prepTime, String cookTime, int rating,
                          int servings,List<String> ingredients, List<String> steps, String imageUrl) {}

    record ResponseRecipe(int id, String title) {}

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseRecipe createRecipe(@RequestBody RequestRecipe recipe) {
        Recipe saveRecipe = recipeService.saveRecipe(
                new Recipe(
                        recipe.title, recipe.prepTime,recipe.cookTime,
                        recipe.rating,recipe.servings, recipe.ingredients, recipe.steps, recipe.imageUrl
                )
        );
        return new ResponseRecipe(saveRecipe.getId(), saveRecipe.getTitle());
    }
}
