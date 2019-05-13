package com.ensas.configs;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SingletonConnection {

	private static EntityManagerFactory emf=null;
	private static EntityManager em=null;
	
	private SingletonConnection() {
		emf=Persistence.createEntityManagerFactory("payement_abonnement");
		em=emf.createEntityManager(); 
	}

	
	public static EntityManager getConnection() {
		if(em==null) {
			new SingletonConnection();
		}
		return em;
	}

}
