package com.monapp.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="ITEM")
public class Item {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="NOM_ITEM")
	private String nomItem;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="IMAGE_ITEM")
	private String imageItem;
	
	@ManyToMany(mappedBy="listeItemsInventaire")
	private List<Inventaire> listeInventaires;
	
	@ManyToMany(mappedBy="listeItemsScenario")
	private List<Scenario> listeScenarios;

	public Item() {
		super();
	}

	public Item(int id, String nomItem, String description, String imageItem, List<Inventaire> listeInventaires,
			List<Scenario> listeScenarios) {
		super();
		this.id = id;
		this.nomItem = nomItem;
		this.description = description;
		this.imageItem = imageItem;
		this.listeInventaires = listeInventaires;
		this.listeScenarios = listeScenarios;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomItem() {
		return nomItem;
	}

	public void setNomItem(String nomItem) {
		this.nomItem = nomItem;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageItem() {
		return imageItem;
	}

	public void setImageItem(String imageItem) {
		this.imageItem = imageItem;
	}

	public List<Inventaire> getListeInventaires() {
		return listeInventaires;
	}

	public void setListeInventaires(List<Inventaire> listeInventaires) {
		this.listeInventaires = listeInventaires;
	}

	public List<Scenario> getListeScenarios() {
		return listeScenarios;
	}

	public void setListeScenarios(List<Scenario> listeScenarios) {
		this.listeScenarios = listeScenarios;
	}
	
}
