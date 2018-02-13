	package com.supinfo.supcooking.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.supinfo.supcooking.dao.RecipeDAO;
import com.supinfo.supcooking.entity.Recipe;

public class JpaRecipeDAO implements RecipeDAO {
	
	private EntityManagerFactory factory;
	
	public JpaRecipeDAO(EntityManagerFactory factory) {
		this.factory = factory;
	}

	//
	// Override de toutes les méthodes de la classe
	// Lors d'un ajout, update ou suppression dans la base de données, il faut déclarer une transaction (EntityManager.getTransaction())
	// Sinon la transaction est facultative (SELECT)
	//
	
	@Override
	public void addRecipe(Recipe aRecipe) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(aRecipe);
			manager.flush();
			transaction.commit();
		} catch (Exception e) {
			// Si il y a une erreur et que la transaction est ouverte on rollback la transaction
			if(transaction.isActive()) transaction.rollback();
		}
		
		manager.close();
	}

	@Override
	public Recipe findRecipeById(Long id) {
		Recipe aRecipe;
		try {
			EntityManager manager = factory.createEntityManager();
			aRecipe = (Recipe) manager.createQuery("SELECT recipe FROM Recipe AS recipe WHERE recipe.id = "+id).getSingleResult();
			manager.close();
		} catch (Exception e) {
			throw e;
		}
		return aRecipe;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Recipe> getAllRecipes() {
		List<Recipe> lesRecipes;
		try {
			EntityManager manager = factory.createEntityManager();
			lesRecipes = (List<Recipe>) manager.createQuery("SELECT recipe FROM Recipe AS recipe").getResultList();
			manager.close();
		} catch (Exception e) {
			throw e;
		}
		return lesRecipes;
	}

	@Override
	public void updateRecipe(Recipe aRecipe) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.createQuery("UPDATE Recipe AS recipe SET recipe.name = '"+aRecipe.getName()+"' WHERE recipe.id="+aRecipe.getId()).executeUpdate();
			manager.createQuery("UPDATE Recipe AS recipe SET recipe.description = '"+aRecipe.getRecipeDescription()+"' WHERE recipe.id="+aRecipe.getId()).executeUpdate();
			manager.createQuery("UPDATE Recipe AS recipe SET recipe.icon = "+aRecipe.getIcon()+" WHERE recipe.id="+aRecipe.getId()).executeUpdate();
			manager.createQuery("UPDATE Recipe AS recipe SET recipe.time = "+aRecipe.getTime()+" WHERE recipe.id="+aRecipe.getId()).executeUpdate();
			manager.createQuery("UPDATE Recipe AS recipe SET recipe.difficulty = "+aRecipe.getDifficulty()+" WHERE recipe.id="+aRecipe.getId()).executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			// Si il y a une erreur et que la transaction est ouverte on rollback la transaction
			if(transaction.isActive()) transaction.rollback();
		}
		manager.close();
	}

	@Override
	public void removeRecipe(Recipe aRecipe) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.createQuery("DELETE FROM Recipe AS recipe WHERE recipe.id = "+aRecipe.getId()).executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			// Si il y a une erreur et que la transaction est ouverte on rollback la transaction
			if(transaction.isActive()) transaction.rollback();
		}
		manager.close();
	}
}
