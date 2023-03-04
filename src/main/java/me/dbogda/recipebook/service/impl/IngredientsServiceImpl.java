package me.dbogda.recipebook.service.impl;

import me.dbogda.recipebook.model.Ingredient;
import me.dbogda.recipebook.service.IngredientsService;
import me.dbogda.recipebook.service.exceptions.IdNotFoundException;
import me.dbogda.recipebook.service.exceptions.IncorrectArgumentException;

import java.util.HashMap;

@org.springframework.stereotype.Service
public class IngredientsServiceImpl implements IngredientsService {
    public HashMap<Integer, Ingredient> ingredients = new HashMap<>();
    private Integer id = 0;

    @Override
    public void putIngredients(Ingredient ingredient) throws IncorrectArgumentException {
        if (ingredient != null) {
            ingredients.put(id++, ingredient);
        } else {
            throw new IncorrectArgumentException("There is not ingredient!");
        }
    }

    @Override
    public Ingredient getIngredientByID(Integer id) throws IdNotFoundException {
        if (id < ingredients.size() + 1 || id == 0) {
            throw new IdNotFoundException("There is not ingredient ID = " + id);
        } else {
            return ingredients.get(id);
        }
    }

}

