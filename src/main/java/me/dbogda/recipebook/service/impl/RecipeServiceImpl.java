package me.dbogda.recipebook.service.impl;

import me.dbogda.recipebook.model.Recipe;
import me.dbogda.recipebook.service.RecipeService;

import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Service
public class RecipeServiceImpl implements RecipeService {
   private final HashMap<Integer, Recipe> recipeMap = new HashMap<>();

   private static Integer id = 0;

   @Override
   public int putRecipe(Recipe recipe) {
      if (recipe != null) {
         recipeMap.put(id, recipe);
      }
      return id++;
   }

   @Override
   public String getRecipeByID(Integer id) {
      if (recipeMap.get(id) == null) {
         System.out.println("There is not recipe with id= " + id);
      }
      return recipeMap.get(id).toString();
   }

   @Override
   public String deleteRecipe(int id) {
      if (recipeMap.containsKey(id)) {
         recipeMap.remove(id);
         return "ingredient with id = " + id + " has been deleted";
      }
      return "There is not ingredients with id= " + id;
   }

   @Override
   public Recipe editRecipe(int id, Recipe recipe) {
      if (recipeMap.containsKey(id)) {
         recipeMap.put(id, recipe);
         return recipe;
      }
      return null;
   }

   @Override
   public  Map<Integer, Recipe> getAllRecipes() {
     return recipeMap;
   }
}

