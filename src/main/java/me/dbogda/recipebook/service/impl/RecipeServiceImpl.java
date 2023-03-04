package me.dbogda.recipebook.service.impl;

import me.dbogda.recipebook.model.Recipe;
import me.dbogda.recipebook.service.RecipeService;
import me.dbogda.recipebook.service.exceptions.IdNotFoundException;
import me.dbogda.recipebook.service.exceptions.IncorrectArgumentException;

import java.util.HashMap;
import java.util.Objects;

@org.springframework.stereotype.Service
public class RecipeServiceImpl implements RecipeService {
   private final HashMap<Integer, Recipe> recipeMap = new HashMap<>();
   private Integer id = 0;

   @Override
   public void putRecipe(Recipe recipe) throws IncorrectArgumentException {
      if (!Objects.isNull(recipe)) {
         recipeMap.put(id++, recipe);
      } else {
         throw new IncorrectArgumentException("You can't put a null recipe!");
      }
   }

   @Override
   public Recipe getRecipeByID (Integer id) throws IdNotFoundException {
      if (id < recipeMap.size() + 1 || id == 0) {
         throw new IdNotFoundException("There is not recipe ID = " + id);
      } else {
         return recipeMap.get(id);
      }
   }
}
