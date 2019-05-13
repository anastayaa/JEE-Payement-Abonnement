package com.ensas.daos;

import com.ensas.models.Payement;

public interface PayementDAO {
	
	boolean addPayement(Payement payement, String numeroCarte);

}
