package com.ensas.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ensas.configs.SingletonConnection;
import com.ensas.models.Client;

public class ClientDAOImpl implements ClientDAO{

	private EntityManager em=SingletonConnection.getConnection();
	
	public Client login(String login, String mdp) {
		Client client=null;
		try {
			Query query=em.createQuery("SELECT c FROM Client c WHERE c.login=:login AND c.mdp=:mdp");
			query.setParameter("login", login);
			query.setParameter("mdp", mdp);
			if(query.getResultList()!=null) {
				client=(Client) query.getResultList().get(0);
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return client;
	}
	
	
	public List<Client> getAllClient(){
		List<Client> clients=null;
		try {
		Query query=em.createQuery("SELECT c FROM Client c");
		clients=query.getResultList();
		}
		catch (Exception e) {
		}
		return clients;
	}

}
