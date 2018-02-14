package com.supinfo.supcooking.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.supinfo.supcooking.dao.IngredientDAO;
import com.supinfo.supcooking.entity.Ingredient;

public class JpaIngredientDao implements IngredientDAO {
	
	private EntityManagerFactory factory;
	
	public JpaIngredientDao(EntityManagerFactory factory) {
		this.factory = factory;
	}

	//
	// Override de toutes les méthodes de la classe
	// Lors d'un ajout, update ou suppression dans la base de données, il faut déclarer une transaction (EntityManager.getTransaction())
	// Sinon la transaction est facultative (SELECT)
	//
	
	@Override
	public void addIngredient(Ingredient aIngredient) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		try {
			transaction.begin();
			manager.persist(aIngredient);
			manager.flush();
			transaction.commit();
		} catch (Exception e) {
			// Si il y a une erreur et que la transaction est ouverte on rollback la transaction
			if(transaction.isActive()) transaction.rollback();
		}
		
		manager.close();
	}

	@Override
	public Ingredient findIngredientById(Long id) {
		Ingredient aIngredient;
		try {
			EntityManager manager = factory.createEntityManager();
			aIngredient = (Ingredient) manager.createQuery("SELECT ingredient FROM Ingredient AS ingredient WHERE ingredient.id = "+id).getSingleResult();
			manager.close();
		} catch (Exception e) {
			throw e;
		}
		return aIngredient;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ingredient> getAllIngredients() {
		List<Ingredient> lesIngredients;
		try {
			EntityManager manager = factory.createEntityManager();
			lesIngredients = (List<Ingredient>) manager.createQuery("SELECT ingredient FROM Ingredient AS ingredient").getResultList();
			manager.close();
		} catch (Exception e) {
			throw e;
		}
		return lesIngredients;
	}

	@Override
	public void updateIngredient(Ingredient aIngredient) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.createQuery("UPDATE Ingredient AS ingredient SET ingredient.name = '"+aIngredient.getNameIngredient()+"' WHERE ingredient.id="+aIngredient.getId()).executeUpdate();
			manager.createQuery("UPDATE Ingredient AS ingredient SET ingredient.price = '"+aIngredient.getPrice()+"' WHERE ingredient.id="+aIngredient.getId()).executeUpdate();
			manager.createQuery("UPDATE Ingredient AS ingredient SET ingredient.image = '"+aIngredient.getImage()+"' WHERE ingredient.id="+aIngredient.getId()).executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			// Si il y a une erreur et que la transaction est ouverte on rollback la transaction
			if(transaction.isActive()) transaction.rollback();
		}
		manager.close();
	}

	@Override
	public void removeIngredient(Ingredient aIngredient) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.createQuery("DELETE FROM Ingredient AS ingredient WHERE ingredient.id = "+aIngredient.getId()).executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			// Si il y a une erreur et que la transaction est ouverte on rollback la transaction
			if(transaction.isActive()) transaction.rollback();
		}
		manager.close();
	}
}
