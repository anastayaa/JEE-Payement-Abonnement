package com.ensas.services;

import com.ensas.models.Payement;

public interface PayementService {

	boolean addPayement(Payement payement, String numeroCarte);
	
}
