package me.dbogda.recipebook.service;

import me.dbogda.recipebook.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface RecipeService {
    int putRecipe(Recipe recipe);

    String getRecipeByID (Integer id);

    String deleteRecipe(int id);

    Recipe editRecipe(int id, Recipe recipe);

    Map<Integer, Recipe> getAllRecipes();
}
