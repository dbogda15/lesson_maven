package me.dbogda.recipebook.controllers;

import me.dbogda.recipebook.model.Recipe;
import me.dbogda.recipebook.service.RecipeService;
import me.dbogda.recipebook.service.exceptions.IdNotFoundException;
import me.dbogda.recipebook.service.exceptions.IncorrectArgumentException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController (RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping("/add")
    public void createRecipe (Recipe recipe) throws IncorrectArgumentException {
        recipeService.putRecipe(recipe);
    }

    @GetMapping("/get")
    public Recipe getRecipe (@RequestParam int id) throws IdNotFoundException {
        return recipeService.getRecipeByID(id);
    }
}
