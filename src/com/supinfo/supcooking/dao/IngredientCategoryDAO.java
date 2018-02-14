package com.supinfo.supcooking.dao;

import java.util.List;

import com.supinfo.supcooking.entity.IngredientCategory;

public interface IngredientCategoryDAO {
	
	// Définition des méthodes de l'interface
	void addIngredientCategory(IngredientCategory aCateg);
	IngredientCategory findIngredientCategoryById(Long id);
	List<IngredientCategory> getAllIngredientCategories();
	void updateIngredientCategory(IngredientCategory aCateg);
	void removeIngredientCategory(IngredientCategory aCateg);
}
