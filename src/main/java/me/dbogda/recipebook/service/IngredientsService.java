package me.dbogda.recipebook.service;

import me.dbogda.recipebook.model.Ingredient;
import me.dbogda.recipebook.service.exceptions.IdNotFoundException;
import me.dbogda.recipebook.service.exceptions.IncorrectArgumentException;
import org.springframework.stereotype.Service;

@Service
public interface IngredientsService {
     void putIngredients(Ingredient ingredient) throws IncorrectArgumentException;

    Ingredient getIngredientByID (Integer id) throws IdNotFoundException;
}
