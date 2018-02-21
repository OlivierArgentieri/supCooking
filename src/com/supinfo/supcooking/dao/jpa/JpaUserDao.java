package com.supinfo.supcooking.dao.jpa;

import java.util.List;
import java.util.Map;

import javax.persistence.Cache;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnitUtil;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.metamodel.Metamodel;

import com.supinfo.supcooking.dao.UserDAO;
import com.supinfo.supcooking.entity.User;

public class JpaUserDao implements UserDAO {
	
	private EntityManagerFactory factory;
	
	public JpaUserDao() {
		this.factory = new EntityManagerFactory() {
			
			@Override
			public boolean isOpen() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public Map<String, Object> getProperties() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public PersistenceUnitUtil getPersistenceUnitUtil() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Metamodel getMetamodel() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public CriteriaBuilder getCriteriaBuilder() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Cache getCache() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public EntityManager createEntityManager(Map arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public EntityManager createEntityManager() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void close() {
				// TODO Auto-generated method stub
				
			}
		};
	}

	//
	// Override de toutes les m�thodes de la classe
	// Lors d'un ajout, update ou suppression dans la base de donn�es, il faut d�clarer une transaction (EntityManager.getTransaction())
	// Sinon la transaction est facultative (SELECT)
	//
	
	@Override
	public void addUser(User aUser) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		try {
			transaction.begin();
			manager.persist(aUser);
			manager.flush();
			transaction.commit();
		} catch (Exception e) {
			// Si il y a une erreur et que la transaction est ouverte on rollback la transaction
			if(transaction.isActive()) transaction.rollback();
		}
		
		manager.close();
	}

	@Override
	public User findUserById(Long id) {
		User aUser;
		try {
			EntityManager manager = factory.createEntityManager();
			aUser = (User) manager.createQuery("SELECT user FROM User AS user WHERE user.id = "+id).getSingleResult();
			manager.close();
		} catch (Exception e) {
			throw e;
		}
		return aUser;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		List<User> lesUsers;
		try {
			EntityManager manager = factory.createEntityManager();
			lesUsers = (List<User>) manager.createQuery("SELECT user FROM User AS user").getResultList();
			manager.close();
		} catch (Exception e) {
			throw e;
		}
		return lesUsers;
	}

	@Override
	public void updateUser(User aUser) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.createQuery("UPDATE User AS user SET user.username = '"+aUser.getUsername()+"' WHERE user.id="+aUser.getId()).executeUpdate();
			manager.createQuery("UPDATE User AS user SET user.password = '"+aUser.getPassword()+"' WHERE user.id="+aUser.getId()).executeUpdate();
			manager.createQuery("UPDATE User AS user SET user.firstname = '"+aUser.getFirstName()+"' WHERE user.id="+aUser.getId()).executeUpdate();
			manager.createQuery("UPDATE User AS user SET user.lastname = '"+aUser.getLastName()+"' WHERE user.id="+aUser.getId()).executeUpdate();
			manager.createQuery("UPDATE User AS user SET user.mail = '"+aUser.getMail()+"' WHERE user.id="+aUser.getId()).executeUpdate();
			manager.createQuery("UPDATE User AS user SET user.name = '"+aUser.getPhoneNumber()+"' WHERE user.id="+aUser.getId()).executeUpdate();
			manager.createQuery("UPDATE User AS user SET user.address = '"+aUser.getAddress()+"' WHERE user.id="+aUser.getId()).executeUpdate();
			manager.createQuery("UPDATE User AS user SET user.postcode = '"+aUser.getPostCode()+"' WHERE user.id="+aUser.getId()).executeUpdate();
			manager.createQuery("UPDATE User AS user SET user.description = '"+aUser.getDescription()+"' WHERE user.id="+aUser.getId()).executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			// Si il y a une erreur et que la transaction est ouverte on rollback la transaction
			if(transaction.isActive()) transaction.rollback();
		}
		manager.close();
	}

	@Override
	public void removeUser(User aUser) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.createQuery("DELETE FROM User AS user WHERE user.id = "+aUser.getId()).executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			// Si il y a une erreur et que la transaction est ouverte on rollback la transaction
			if(transaction.isActive()) transaction.rollback();
		}
		manager.close();
	}
	
	public boolean existUser(User aUser) {
		if(findUserById(aUser.getId()) != null)
			return true;
		return false;
	}
}
