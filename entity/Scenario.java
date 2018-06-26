package com.monapp.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="SCENARIO")
public class Scenario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="SCENE")
	private String scene;
	
	@OneToOne(mappedBy="scenario")
	private Route route;
	
	@ManyToMany
	@JoinTable(name="SCENARIO_ITEM",
	joinColumns = @JoinColumn(name="SCENARIO_ID"),
	inverseJoinColumns = @JoinColumn(name="ITEM_ID"))
	private List<Item> listeItemsScenario;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="PARTIE_ID")
	private Partie partie;

	//Constructeurs
	public Scenario() {
		super();
	}

	public Scenario(int id, String scene, Route route, List<Item> listeItemsScenario, Partie partie) {
		super();
		this.id = id;
		this.scene = scene;
		this.route = route;
		this.listeItemsScenario = listeItemsScenario;
		this.partie = partie;
	}

	//Getters et Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getScene() {
		return scene;
	}

	public void setScene(String scene) {
		this.scene = scene;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public List<Item> getListeItemsScenario() {
		return listeItemsScenario;
	}

	public void setListeItemsScenario(List<Item> listeItemsScenario) {
		this.listeItemsScenario = listeItemsScenario;
	}

	public Partie getPartie() {
		return partie;
	}

	public void setPartie(Partie partie) {
		this.partie = partie;
	}
	
}
