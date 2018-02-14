package com.supinfo.supcooking.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.supinfo.supcooking.dao.IngredientCategoryDAO;
import com.supinfo.supcooking.entity.IngredientCategory;

public class JpaIngredientCategoryDao implements IngredientCategoryDAO {
	
	private EntityManagerFactory factory;
	
	public JpaIngredientCategoryDao(EntityManagerFactory factory) {
		this.factory = factory;
	}

	//
	// Override de toutes les méthodes de la classe
	// Lors d'un ajout, update ou suppression dans la base de données, il faut déclarer une transaction (EntityManager.getTransaction())
	// Sinon la transaction est facultative (SELECT)
	//
	
	@Override
	public void addIngredientCategory(IngredientCategory aCateg) {
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
	public IngredientCategory findIngredientCategoryById(Long id) {
		IngredientCategory aCateg;
		try {
			EntityManager manager = factory.createEntityManager();
			aCateg = (IngredientCategory) manager.createQuery("SELECT ingredient_category FROM IngredientCategory AS ingredient_category WHERE ingredient_category.id = "+id).getSingleResult();
			manager.close();
		} catch (Exception e) {
			throw e;
		}
		return aCateg;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IngredientCategory> getAllIngredientCategories() {
		List<IngredientCategory> lesCategs;
		try {
			EntityManager manager = factory.createEntityManager();
			lesCategs = (List<IngredientCategory>) manager.createQuery("SELECT ingredient_category FROM IngredientCategory AS ingredient_category").getResultList();
			manager.close();
		} catch (Exception e) {
			throw e;
		}
		return lesCategs;
	}

	@Override
	public void updateIngredientCategory(IngredientCategory aCateg) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.createQuery("UPDATE IngredientCategory AS ingredient_category SET ingredient_category.name = '"+aCateg.getName()+"' WHERE ingredient_category.id="+aCateg.getId()).executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			// Si il y a une erreur et que la transaction est ouverte on rollback la transaction
			if(transaction.isActive()) transaction.rollback();
		}
		manager.close();
	}

	@Override
	public void removeIngredientCategory(IngredientCategory aCateg) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.createQuery("DELETE FROM IngredientCategory AS ingredient_category WHERE ingredient_category.id = "+aCateg.getId()).executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			// Si il y a une erreur et que la transaction est ouverte on rollback la transaction
			if(transaction.isActive()) transaction.rollback();
		}
		manager.close();
	}
}
