package com.example.recipesbookapi.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String prepTime;
    private String cookTime;
    private int rating;
    private int servings;
    @ElementCollection
    private List<String> ingredients = new ArrayList<>();
    @ElementCollection
    private List<String> steps = new ArrayList<>();
    private String imageUrl;

    public Recipe() {
    }

    public Recipe(String title, String prepTime, String cookTime, int rating, int servings, List<String> ingredients, List<String> steps, String imageUrl) {
        this.title = title;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.rating = rating;
        this.servings = servings;
        this.ingredients = ingredients;
        this.steps = steps;
        this.imageUrl = imageUrl;
    }
}
