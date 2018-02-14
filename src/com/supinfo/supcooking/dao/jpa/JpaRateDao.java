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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rate findRateById(Long id, String IpAddress) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Rate> getAllRates() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateRate(Rate aRate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeRate(Rate aRate) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			manager.createQuery("DELETE FROM Rate AS rate WHERE rate.id = "+aRate.getId()).executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			// Si il y a une erreur et que la transaction est ouverte on rollback la transaction
			if(transaction.isActive()) transaction.rollback();
		}
		manager.close();
	}

}
