package com.ensas.services;

import java.util.List;

import com.ensas.daos.ClientDAO;
import com.ensas.daos.ClientDAOImpl;
import com.ensas.models.Client;

public class ClientServiceImpl implements ClientService{

	private ClientDAO clientDAO=new ClientDAOImpl();
	
	public Client login(String login, String mdp) {
		return clientDAO.login(login, mdp);
	}

	public List<Client> getAllClient(){
		return clientDAO.getAllClient();
	}
}
