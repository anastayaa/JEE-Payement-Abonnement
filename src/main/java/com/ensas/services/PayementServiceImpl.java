package com.ensas.services;

import com.ensas.daos.PayementDAO;
import com.ensas.daos.PayementDAOImpl;
import com.ensas.models.Payement;

public class PayementServiceImpl implements PayementService{

	private PayementDAO payementDAO=new PayementDAOImpl();
	
	public boolean addPayement(Payement payement, String numeroCarte) {
		return payementDAO.addPayement(payement, numeroCarte);
	}

}
