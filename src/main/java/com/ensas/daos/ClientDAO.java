package com.ensas.daos;

import java.util.List;

import com.ensas.models.Client;

public interface ClientDAO {
	
	Client login(String nom, String mdp);
	List<Client> getAllClient();
}
