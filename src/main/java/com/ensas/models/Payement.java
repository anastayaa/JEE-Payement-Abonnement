package com.ensas.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Payement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carte_numero")
	private Carte carte;
	private int date;
	private int dernierChiffres;
	public Payement() {
		
	}
	
	public Payement(int date, int dernierChiffres) {
		super();
		this.date = date;
		this.dernierChiffres = dernierChiffres;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Carte getCarte() {
		return carte;
	}

	public void setCarte(Carte carte) {
		this.carte = carte;
	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getDernierChiffres() {
		return dernierChiffres;
	}

	public void setDernierChiffres(int dernierChiffres) {
		this.dernierChiffres = dernierChiffres;
	}
	
}
