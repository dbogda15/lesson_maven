package me.dbogda.recipebook.controllers;

import me.dbogda.recipebook.model.Ingredient;
import me.dbogda.recipebook.service.IngredientsService;
import me.dbogda.recipebook.service.exceptions.IncorrectArgumentException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ingredients")
public class IngredientsController {

    private IngredientsService ingredientsService;

    public IngredientsController (IngredientsService ingredientsService) {
        this.ingredientsService = ingredientsService;
    }

    @PostMapping ("/add")
    public void createIngredients (Ingredient ingredient) throws IncorrectArgumentException {
        ingredientsService.putIngredients(ingredient);
    }
}
