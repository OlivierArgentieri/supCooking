package com.supinfo.supcooking.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {
	private static EntityManagerFactory emf;
	private PersistenceManager()
	{}
	
	public static EntityManagerFactory persistenceEntity()
	{
		if(emf == null)
		emf =  Persistence.createEntityManagerFactory("My-PU");
		return emf;
	}
	public static void closePersistenceEntity()
	{
		emf.close();
	}
}
