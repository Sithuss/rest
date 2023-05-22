package com.example.recipesbookapi.service;

import com.example.recipesbookapi.dao.RecipeDao;
import com.example.recipesbookapi.model.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecipeService {
    @Autowired
    private RecipeDao recipeDao;

    public Recipe saveRecipe(Recipe recipe) {
       return recipeDao.save(recipe);
    }

    public Iterable<Recipe> findAllRecipe() {
        return recipeDao.findAll();
    }

    public Optional<Recipe> findRecipeById(int id) {
        return recipeDao.findById(id);
    }
}
