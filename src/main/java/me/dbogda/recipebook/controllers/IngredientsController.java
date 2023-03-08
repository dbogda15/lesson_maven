package me.dbogda.recipebook.controllers;

import me.dbogda.recipebook.model.Ingredient;
import me.dbogda.recipebook.service.IngredientsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/ingredients")
public class IngredientsController {

    private final IngredientsService ingredientsService;

    public IngredientsController (IngredientsService ingredientsService) {
        this.ingredientsService = ingredientsService;
    }

    @PostMapping("/add")
    public ResponseEntity<Integer> addIngredients (@RequestBody Ingredient ingredient) {
        int id = ingredientsService.putIngredients(ingredient);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredient> getIngredientById(@PathVariable int id) {
        Ingredient ingredient = ingredientsService.getIngredientByID(id);
        if (ingredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<String> deleteIngredientById(@PathVariable int id) {
        String message = ingredientsService.deleteIngredient(id);
        if (message == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(message);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity <Ingredient> editIngredient(@PathVariable int id, @RequestBody Ingredient ingredient) {
        Ingredient editIngredient = ingredientsService.editIngredient(id, ingredient);
        if (editIngredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(editIngredient);
    }

    @GetMapping("/print")
    public ResponseEntity<Map<Integer, Ingredient>> getAllIngredients () {
        Map<Integer, Ingredient> allIngredientsMap = ingredientsService.getAllIngredients();
        if (allIngredientsMap.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(allIngredientsMap);
    }

}
