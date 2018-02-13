package com.supinfo.supcooking.dao;

import java.util.List;

import com.supinfo.supcooking.entity.Recipe;

public interface RecipeDAO {
	
	// D�finition des m�thodes de l'interface
	void addRecipe(Recipe aRecipe);
	Recipe findRecipeById(Long id);
	List<Recipe> getAllRecipes();
	void updateRecipe(Recipe aRecipe);
	void removeRecipe(Recipe aRecipe);
}
