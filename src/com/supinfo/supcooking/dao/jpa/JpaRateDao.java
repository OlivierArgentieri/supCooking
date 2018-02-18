package com.supinfo.supcooking.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import com.supinfo.supcooking.dao.RateDAO;
import com.supinfo.supcooking.entity.Rate;

public class JpaRateDao implements RateDAO {

private EntityManagerFactory factory;
	
	public JpaRateDao(EntityManagerFactory factory) {
		this.factory = factory;
	}
	
	
	@Override
	public void addRate(Rate aRate) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.persist(aRate);
			manager.flush();
			transaction.commit();
		} catch (Exception e) {
			// Si il y a une erreur et que la transaction est ouverte on rollback la transaction
			if(transaction.isActive()) transaction.rollback();
		}
		
		manager.close();
	}

	@Override
	public Rate findRateById(Long id, String IpAddress) {
		Rate aRate;
		try {
			EntityManager manager = factory.createEntityManager();
			aRate = (Rate) manager.createQuery("SELECT rate FROM rate AS rate WHERE rate.id = "+id + "AND rate.ip =" + IpAddress).getSingleResult();
			manager.close();
		} catch (Exception e) {
			throw e;
		}
		return aRate;
	}

	@Override
	public List<Rate> getAllRates() {
		List<Rate> lesRates;
		try {
			EntityManager manager = factory.createEntityManager();
			lesRates = (List<Rate>) manager.createQuery("SELECT rate FROM rate AS rate").getResultList();
			manager.close();
		} catch (Exception e) {
			throw e;
		}
		return lesRates;
	}

	@Override
	public void updateRate(Rate aRate) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.createQuery("UPDATE Rate AS rate SET rate.rating = '"+aRate.getRating()+"' WHERE rate.id="+aRate.getId() + "AND rate.ip="+ aRate.getIp()).executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			// Si il y a une erreur et que la transaction est ouverte on rollback la transaction
			if(transaction.isActive()) transaction.rollback();
		}
		manager.close();
	}

	@Override
	public void removeRate(Rate aRate) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.createQuery("DELETE FROM Rate AS rate WHERE rate.id = "+aRate.getId() + "AND rate.ip = "+ aRate.getIp()).executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			// Si il y a une erreur et que la transaction est ouverte on rollback la transaction
			if(transaction.isActive()) transaction.rollback();
		}
		manager.close();
	}

}
