package me.dbogda.recipebook.controllers;

import me.dbogda.recipebook.model.Ingredient;
import me.dbogda.recipebook.service.IngredientsService;
import me.dbogda.recipebook.service.exceptions.IdNotFoundException;
import me.dbogda.recipebook.service.exceptions.IncorrectArgumentException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingredients")
public class IngredientsController {

    private final IngredientsService ingredientsService;

    public IngredientsController (IngredientsService ingredientsService) {
        this.ingredientsService = ingredientsService;
    }

    @PostMapping  ("/add")
    public void createIngredients (Ingredient ingredient) throws IncorrectArgumentException {
        ingredientsService.putIngredients(ingredient);
    }

    @GetMapping ("/get")
    public Ingredient getIngredient (@RequestParam int id) throws IdNotFoundException {
        return ingredientsService.getIngredientByID(id);
    }
}
