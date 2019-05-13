package com.ensas.daos;

import javax.persistence.EntityManager;

import com.ensas.configs.SingletonConnection;
import com.ensas.models.Carte;
import com.ensas.models.Payement;

public class PayementDAOImpl implements PayementDAO{

	private EntityManager em=SingletonConnection.getConnection();
	
	public boolean addPayement(Payement payement, String numeroCarte) {
		try {
			if(em!=null) {
				Carte carte=em.find(Carte.class, numeroCarte);
				payement.setCarte(carte);
				em.getTransaction().begin();
				em.persist(payement);
				em.getTransaction().commit();
				return true;
			}
			else {
				System.out.println("erreur au niveau du serveur");
				return false;
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			return false;
		}
	}
	
}
