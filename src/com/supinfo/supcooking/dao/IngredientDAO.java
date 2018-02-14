package com.supinfo.supcooking.dao;

import java.util.List;

import com.supinfo.supcooking.entity.Ingredient;

public interface IngredientDAO {
	
	// D�finition des m�thodes de l'interface
	void addIngredient(Ingredient aIngredient);
	Ingredient findIngredientById(Long id);
	List<Ingredient> getAllIngredients();
	void updateIngredient(Ingredient aIngredient);
	void removeIngredient(Ingredient aIngredient);
}
