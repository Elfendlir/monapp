package com.monapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.monapp.enumeration.Job;

@Entity
@Table(name="PERSONNAGE")
public class Personnage {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="NAME", nullable=false, length=160)
	private String name;
	
	@Column(name="IMAGE")
	private String image;
	
	@Column(name="JOB")
	private Job job;

	@OneToOne(mappedBy="perso")
	@JsonIgnoreProperties("perso")
	private Partie partie;
	
	@NotNull
	@OneToOne
	@JoinColumn(name="INVENTAIRE_ID")
	//@JsonIgnoreProperties("personnage")
	private Inventaire inventaire;
	
	public Personnage() {
	}
	
	public Personnage(int id, String name, String image, Job job, Partie partie, @NotNull Inventaire inventaire) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.job = job;
		this.partie = partie;
		this.inventaire = inventaire;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public Job getJob() {
		return job;
	}
	
	public void setJob(Job job) {
		this.job = job;
	}
	
	public Inventaire getInventaire() {
		return inventaire;
	}
	
	public void setInventaire(Inventaire inventaire) {
		this.inventaire = inventaire;
	}

	public Partie getPartie() {
		return partie;
	}

	public void setPartie(Partie partie) {
		this.partie = partie;
	}
	
}