package me.dbogda.recipebook.controllers;

import me.dbogda.recipebook.model.Recipe;
import me.dbogda.recipebook.service.RecipeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController (RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping("/add")
    public ResponseEntity <Integer> postRecipe (@RequestBody Recipe recipe) {
        int id = recipeService.putRecipe(recipe);
        if (recipe==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getRecipe (@PathVariable int id) {
        String recipe = recipeService.getRecipeByID(id);
        if (recipe == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipe);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRecipe (@PathVariable int id) {
        String message = recipeService.deleteRecipe(id);
        if (message == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(message);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Recipe> editRecipe (@PathVariable int id, @RequestBody Recipe recipe) {
        Recipe editRecipe = recipeService.editRecipe(id, recipe);
        if (editRecipe==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(editRecipe);
    }

    @GetMapping("/print")
    public ResponseEntity<Map<Integer, Recipe>> getAllRecipes (){
        Map<Integer, Recipe> allRecipesMap = recipeService.getAllRecipes();
        if (allRecipesMap.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(allRecipesMap);
    }
}
