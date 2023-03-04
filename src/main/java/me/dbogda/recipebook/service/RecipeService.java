package me.dbogda.recipebook.service;

import me.dbogda.recipebook.model.Recipe;
import me.dbogda.recipebook.service.exceptions.IdNotFoundException;
import me.dbogda.recipebook.service.exceptions.IncorrectArgumentException;
import org.springframework.stereotype.Service;

@Service
public interface RecipeService {
    void putRecipe(Recipe recipe) throws IncorrectArgumentException;

    Recipe getRecipeByID (Integer id) throws IdNotFoundException;
    }
