package com.example.recipesbookapi.dao;

import com.example.recipesbookapi.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RecipeDao extends CrudRepository<Recipe, Integer> {
}
