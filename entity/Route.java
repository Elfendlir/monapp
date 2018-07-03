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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ROUTE")
public class Route {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="SCENE")
	private String scene;
	
	@Column(name="IMAGE_SCENE")
	private String imageScene;
	
	@Column(name="PREMIERE_SCENE")
	private Boolean premiereRoute;
	
	@OneToMany(mappedBy="currentRoute")
	private List<Partie> listeParties;
	
	@ManyToOne
	@JoinColumn(name="ROUTE_INITIALE_ID")
	private Route routeInitiale;
	
	@OneToMany(mappedBy="routeInitiale")
	private List<Route> listeRoutesSuivantes;
	
	@ManyToMany
	@JoinTable(name="ROUTE_ITEM",
	joinColumns = @JoinColumn(name="ROUTE_ID"),
	inverseJoinColumns = @JoinColumn(name="ITEM_ID"))
	private List<Item> listeItemsRoute;
	
	@ManyToOne
	@JoinColumn(name = "SCENARIO_ID")
	private Scenario scenario;
	
	public Route() {
		super();
	}

	public Route(int id, String scene, String imageScene, Boolean premiereRoute, List<Partie> listeParties,
			Route routeInitiale, List<Route> listeRoutesSuivantes, List<Item> listeItemsRoute, Scenario scenario) {
		super();
		this.id = id;
		this.scene = scene;
		this.imageScene = imageScene;
		this.premiereRoute = premiereRoute;
		this.listeParties = listeParties;
		this.routeInitiale = routeInitiale;
		this.listeRoutesSuivantes = listeRoutesSuivantes;
		this.listeItemsRoute = listeItemsRoute;
		this.scenario = scenario;
	}

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

	public Boolean getPremiereRoute() {
		return premiereRoute;
	}

	public void setPremiereRoute(Boolean premiereRoute) {
		this.premiereRoute = premiereRoute;
	}

	public List<Partie> getListeParties() {
		return listeParties;
	}

	public void setListeParties(List<Partie> listeParties) {
		this.listeParties = listeParties;
	}

}