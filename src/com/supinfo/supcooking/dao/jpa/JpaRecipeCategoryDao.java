package com.supinfo.supcooking.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.supinfo.supcooking.dao.RecipeCategoryDAO;
import com.supinfo.supcooking.entity.RecipeCategory;

public class JpaRecipeCategoryDao implements RecipeCategoryDAO {
	
	private EntityManagerFactory factory;
	
	public JpaRecipeCategoryDao(EntityManagerFactory factory) {
		this.factory = factory;
	}

	
	//
	// Override de toutes les méthodes de la classe
	// Lors d'un ajout, update ou suppression dans la base de données, il faut déclarer une transaction (EntityManager.getTransaction())
	// Sinon la transaction est facultative (SELECT)
	//
	
	@Override
	public void addRecipeCategory(RecipeCategory aCateg) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		try {
			transaction.begin();
			manager.persist(aCateg);
			manager.flush();
			transaction.commit();
		} catch (Exception e) {
			// Si il y a une erreur et que la transaction est ouverte on rollback la transaction
			if(transaction.isActive()) transaction.rollback();
		}
		
		manager.close();
	}

	@Override
	public RecipeCategory findRecipeCategoryById(Long id) {
		RecipeCategory aCateg;
		try {
			EntityManager manager = factory.createEntityManager();
			aCateg = (RecipeCategory) manager.createQuery("SELECT recipe_category FROM RecipeCategory AS recipe_category WHERE recipe_category.id = "+id).getSingleResult();
			manager.close();
		} catch (Exception e) {
			throw e;
		}
		return aCateg;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RecipeCategory> getAllRecipeCategories() {
		List<RecipeCategory> lesCategs;
		try {
			EntityManager manager = factory.createEntityManager();
			lesCategs = (List<RecipeCategory>) manager.createQuery("SELECT recipe_category FROM RecipeCategory AS recipe_category").getResultList();
			manager.close();
		} catch (Exception e) {
			throw e;
		}
		return lesCategs;
	}

	@Override
	public void updateRecipeCategory(RecipeCategory aCateg) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.createQuery("UPDATE RecipeCategory AS recipe_category SET recipe_category.name = '"+aCateg.getName()+"' WHERE recipe_category.id="+aCateg.getId()).executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			// Si il y a une erreur et que la transaction est ouverte on rollback la transaction
			if(transaction.isActive()) transaction.rollback();
		}
		manager.close();
	}

	@Override
	public void removeRecipeCategory(RecipeCategory aCateg) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.createQuery("DELETE FROM RecipeCategory AS recipe_category WHERE recipe_category.id = "+aCateg.getId()).executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			// Si il y a une erreur et que la transaction est ouverte on rollback la transaction
			if(transaction.isActive()) transaction.rollback();
		}
		manager.close();
	}
}
