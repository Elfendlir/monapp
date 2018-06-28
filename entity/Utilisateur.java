package com.monapp.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "USER_DATA")
public class Utilisateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;

	@NotNull
	@Size(min = 4)
	@Column(name="NOM")
	private String nom;

	@Email
	@NotNull
	@Column(name="EMAIL")
	private String email;

	@NotNull
	@Column(name="PASSWORD")
	private String mdp;
	
	@OneToMany(mappedBy="user")
	@JsonIgnoreProperties("user")
	private List<Partie> listeParties;

	public Utilisateur() {
		super();
	}

	public Utilisateur(int id, @NotNull @Size(min = 4) String nom, @Email @NotNull String email, @NotNull @NotNull String mdp,
			List<Partie> listeParties) {
		super();
		this.id = id;
		this.nom = nom;
		this.email = email;
		this.mdp = mdp;
		this.listeParties = listeParties;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public @NotNull String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public List<Partie> getListeParties() {
		return listeParties;
	}

	public void setListeParties(List<Partie> listeParties) {
		this.listeParties = listeParties;
	}

}