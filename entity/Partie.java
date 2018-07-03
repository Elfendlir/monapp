package com.monapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="PARTIE")
public class Partie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@OneToOne
	@JoinColumn(name="PERSO_ID")
	@JsonIgnoreProperties(value={"partie","inventaire"}, allowSetters = true)
	private Personnage perso;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="SCENARIO_ID")
	@JsonIgnoreProperties({"listeParties","listeRoutes"})
	private Scenario scenario;
	
	@ManyToOne
	@JoinColumn(name="CURRENT_ROUTE_ID")
	private Route currentRoute;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private Utilisateur user;
	
	public Partie() {
	}

	public Partie(int id, Personnage perso, @NotNull Scenario scenario, Route currentRoute, Utilisateur user) {
		super();
		this.id = id;
		this.perso = perso;
		this.scenario = scenario;
		this.currentRoute = currentRoute;
		this.user = user;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Personnage getPerso() {
		return perso;
	}
	
	public void setPerso(Personnage perso) {
		this.perso = perso;
	}
	
	public Scenario getScenario() {
		return scenario;
	}

	public void setScenario(Scenario scenario) {
		this.scenario = scenario;
	}

	public Utilisateur getUser() {
		return user;
	}
	
	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public Route getCurrentRoute() {
		return currentRoute;
	}

	public void setCurrentRoute(Route currentRoute) {
		this.currentRoute = currentRoute;
	}
	
}