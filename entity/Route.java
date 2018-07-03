package com.monapp.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ROUTE")
public class Route {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;

	@Column(name="TITRE")
	private String titre;
	
	@Column(name="SCENE")
	private String scene;
	
	@Column(name="IMAGE_SCENE")
	private String imageScene;
	
	@Column(name="DEBUT")
	private boolean debut;
	
	@OneToMany(mappedBy="currentRoute")
	private List<Partie> listeParties;
	
	@ManyToOne
	@JoinColumn(name="ROUTE_INITIALE_ID")
	@JsonIgnoreProperties({"listeRoutesSuivantes"})
	private Route routeInitiale;
	
	@OneToMany(mappedBy="routeInitiale")
	@JsonIgnoreProperties({"listeParties","listeRoutesSuivantes","listeItemsRoute"})
	private List<Route> listeRoutesSuivantes;
	
	@ManyToMany
	@JoinTable(name="ROUTE_ITEM",
	joinColumns = @JoinColumn(name="ROUTE_ID"),
	inverseJoinColumns = @JoinColumn(name="ITEM_ID"))
	@JsonIgnoreProperties({"listeRoutes"})
	private List<Item> listeItemsRoute;
	
	@ManyToOne
	@JoinColumn(name = "SCENARIO_ID")
	@JsonIgnoreProperties({"listeRoutes","listeParties"})
	private Scenario scenario;
	
	public Route() {
		super();
	}

	public Route(int id, String titre, String scene, String imageScene, boolean debut, List<Partie> listeParties,
			Route routeInitiale, List<Route> listeRoutesSuivantes, List<Item> listeItemsRoute, Scenario scenario) {
		super();
		this.id = id;
		this.titre = titre;
		this.scene = scene;
		this.imageScene = imageScene;
		this.debut = debut;
		this.listeParties = listeParties;
		this.routeInitiale = routeInitiale;
		this.listeRoutesSuivantes = listeRoutesSuivantes;
		this.listeItemsRoute = listeItemsRoute;
		this.scenario = scenario;
	}

	public int getId() {
		return id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public boolean isDebut() {
		return debut;
	}

	public void setDebut(boolean debut) {
		this.debut = debut;
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

	public String getImageScene() {
		return imageScene;
	}

	public void setImageScene(String imageScene) {
		this.imageScene = imageScene;
	}

	public List<Route> getListeRoutesSuivantes() {
		return listeRoutesSuivantes;
	}

	public void setListeRoutesSuivantes(List<Route> listeRoutesSuivantes) {
		this.listeRoutesSuivantes = listeRoutesSuivantes;
	}

	public List<Item> getListeItemsRoute() {
		return listeItemsRoute;
	}

	public void setListeItemsRoute(List<Item> listeItemsRoute) {
		this.listeItemsRoute = listeItemsRoute;
	}

	public Scenario getScenario() {
		return scenario;
	}

	public void setScenario(Scenario scenario) {
		this.scenario = scenario;
	}

	public Route getRouteInitiale() {
		return routeInitiale;
	}

	public void setRouteInitiale(Route routeInitiale) {
		this.routeInitiale = routeInitiale;
	}

	public List<Partie> getListeParties() {
		return listeParties;
	}

	public void setListeParties(List<Partie> listeParties) {
		this.listeParties = listeParties;
	}

}