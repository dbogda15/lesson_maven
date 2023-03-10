package me.dbogda.recipebook.service;

import me.dbogda.recipebook.model.Ingredient;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface IngredientsService {
     int putIngredients(Ingredient ingredient);

    Ingredient getIngredientByID (Integer id);

    Ingredient editIngredient(int id, Ingredient ingredient);

    String deleteIngredient(int id);

    Map<Integer, Ingredient> getAllIngredients();
}
