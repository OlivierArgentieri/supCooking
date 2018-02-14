package com.supinfo.supcooking.dao;

import java.util.List;

import com.supinfo.supcooking.entity.RecipeCategory;

public interface RecipeCategoryDAO {
	
	// D�finition des m�thodes de l'interface
	void addRecipeCategory(RecipeCategory aCateg);
	RecipeCategory findRecipeCategoryById(Long id);
	List<RecipeCategory> getAllRecipeCategories();
	void updateRecipeCategory(RecipeCategory aCateg);
	void removeRecipeCategory(RecipeCategory aCateg);
}
