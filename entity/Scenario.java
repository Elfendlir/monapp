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

@Entity
@Table(name="SCENARIO")
public class Scenario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@OneToMany(mappedBy="scenario")
	private List<Route> listeRoutes;
	
	@NotNull
	@OneToOne
	@JoinColumn(name="PARTIE_ID")
	private Partie partie;

	public Scenario() {
		super();
	}

	public Scenario(int id, List<Route> listeRoutes, @NotNull Partie partie) {
		super();
		this.id = id;
		this.listeRoutes = listeRoutes;
		this.partie = partie;
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

	public Partie getPartie() {
		return partie;
	}

	public void setPartie(Partie partie) {
		this.partie = partie;
	}
	
}
