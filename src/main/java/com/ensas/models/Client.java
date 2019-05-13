package com.ensas.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private Long id;
	private String nom;
	private String prenom;
	private String role="abonne";
	private String login;
	private String mdp;
	private int montant;
	@OneToMany(mappedBy="client", cascade=CascadeType.ALL, orphanRemoval=true)
	private List<Carte> cartes = new ArrayList<Carte>();
	
	public Client() {
	}

	public Client(String nom, String prenom, int montant) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.montant = montant;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public int getMontant() {
		return montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}

	public List<Carte> getCartes() {
		return cartes;
	}

	public void setCartes(List<Carte> cartes) {
		this.cartes = cartes;
	}

	public void addCarte(Carte carte) {
        cartes.add(carte);
        carte.setClient(this);
    }
	
	public void removeCarte(Carte carte) {
        cartes.remove(carte);
        carte.setClient(null);
    }
}
