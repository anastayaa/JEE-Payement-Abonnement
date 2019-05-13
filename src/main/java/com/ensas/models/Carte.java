package com.ensas.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Carte {
	
	@Id
	@Column(updatable = false, nullable = false)
	private String numero;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;
	@OneToMany(mappedBy="carte", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Payement> payements = new ArrayList<Payement>();
	
	public Carte() {
	}

	public Carte(String numero) {
		this.numero = numero;
	}


	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Payement> getPayements() {
		return payements;
	}

	public void setPayements(List<Payement> payements) {
		this.payements = payements;
	}
	
	public void addPayement(Payement payement) {
        payements.add(payement);
        payement.setCarte(this);
    }
	
	public void removePayement(Payement payement) {
		payements.remove(payement);
        payement.setCarte(null);
	}
}
