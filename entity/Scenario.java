package com.monapp.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="SCENARIO")
public class Scenario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="TITRE")
	private String titre;
	
	@OneToMany(mappedBy="scenario")
	private List<Route> listeRoutes;
	
	@OneToMany(mappedBy="scenario")
	@JsonIgnoreProperties({"perso","scenario"})
	private List<Partie> listeParties;

	public Scenario() {
		super();
	}

	public Scenario(int id, List<Route> listeRoutes, @NotNull List<Partie> listeParties) {
		super();
		this.id = id;
		this.listeRoutes = listeRoutes;
		this.listeParties = listeParties;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Route> getListeRoutes() {
		return listeRoutes;
	}

	public void setListeRoutes(List<Route> listeRoutes) {
		this.listeRoutes = listeRoutes;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public List<Partie> getListeParties() {
		return listeParties;
	}

	public void setListeParties(List<Partie> listeParties) {
		this.listeParties = listeParties;
	}
	
}
