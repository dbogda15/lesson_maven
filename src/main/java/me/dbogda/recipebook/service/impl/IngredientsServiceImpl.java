package me.dbogda.recipebook.service.impl;

import me.dbogda.recipebook.model.Ingredient;
import me.dbogda.recipebook.service.IngredientsService;

import java.util.Map;
import java.util.TreeMap;

@org.springframework.stereotype.Service
public class IngredientsServiceImpl implements IngredientsService {
    public static Map<Integer,Ingredient> ingredients = new TreeMap<>();
    private Integer id = 0;

    @Override
    public int putIngredients(Ingredient ingredient) {
        if (ingredient != null) {
            ingredients.put(id, ingredient);
        }
        return id++;
    }

    @Override
    public Ingredient getIngredientByID(Integer id) {
        if (ingredients.get(id) == null) {
            System.out.println("There is not ingredients with id= " + id);
        }
        return ingredients.get(id);
    }

    @Override
    public Ingredient editIngredient (int id, Ingredient ingredient) {
           if (ingredients.containsKey(id)) {
               ingredients.put(id, ingredient);
               return ingredient;
           }
        return null;
    }

    @Override
    public String deleteIngredient(int id) {
        if (ingredients.containsKey(id)) {
            ingredients.remove(id);
            return "ingredient with id = " + id + " has been deleted";
        }
        return "There is not ingredients with id= " + id;
    }

    @Override
    public Map<Integer, Ingredient> getAllIngredients () {
        return ingredients;
    }
}






