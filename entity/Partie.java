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


@Entity
@Table(name="PARTIE")
public class Partie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@OneToOne(mappedBy="partie")
	private Personnage perso;
	
	@NotNull
	@OneToOne(mappedBy="partie")
	private Scenario scenario;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private Utilisateur user;
	
	public Partie() {
	}
	
	public Partie(int id, Personnage perso, @NotNull Scenario scenario, @NotNull Utilisateur user) {
		super();
		this.id = id;
		this.perso = perso;
		this.scenario = scenario;
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
	
}