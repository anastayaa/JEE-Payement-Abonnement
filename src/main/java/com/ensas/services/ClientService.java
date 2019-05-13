package com.ensas.services;

import java.util.List;

import com.ensas.models.Client;

public interface ClientService {

	Client login(String login, String mdp);
	List<Client> getAllClient();
}
