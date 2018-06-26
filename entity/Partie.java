package com.monapp.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	@OneToMany(mappedBy="partie")
	private List<Scenario> listeScenarios;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private Utilisateur user;
	
	public Partie() {
	}
	
	public Partie(int id, @NotNull Personnage perso, @NotNull List<Scenario> listeScenarios, @NotNull Utilisateur user) {
		super();
		this.id = id;
		this.perso = perso;
		this.listeScenarios = listeScenarios;
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
	
	public List<Scenario> getListeScenarios() {
		return listeScenarios;
	}
	
	public void setListeScenarios(List<Scenario> listeScenarios) {
		this.listeScenarios = listeScenarios;
	}
	
	public Utilisateur getUser() {
		return user;
	}
	
	public void setUser(Utilisateur user) {
		this.user = user;
	}
	
}