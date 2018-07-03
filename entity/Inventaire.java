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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="INVENTAIRE")
public class Inventaire {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@ManyToMany
	@JoinTable(name="INVENTAIRE_ITEM",
	joinColumns = @JoinColumn(name="INVENTAIRE_ID"),
	inverseJoinColumns = @JoinColumn(name="ITEM_ID"))
	private List<Item> listeItemsInventaire;
	
	@OneToOne(mappedBy="inventaire")
	@JsonIgnoreProperties(value={"inventaire"}, allowSetters = true)
	private Personnage personnage;

	public Inventaire() {
		super();
	}

	public Inventaire(int id, List<Item> listeItemsInventaire, @NotNull Personnage personnage) {
		super();
		this.id = id;
		this.listeItemsInventaire = listeItemsInventaire;
		this.personnage = personnage;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Item> getListeItemsInventaire() {
		return listeItemsInventaire;
	}

	public void setListeItemsInventaire(List<Item> listeItemsInventaire) {
		this.listeItemsInventaire = listeItemsInventaire;
	}

	public Personnage getPersonnage() {
		return personnage;
	}

	public void setPerso(Personnage personnage) {
		this.personnage = personnage;
	}
	
}
