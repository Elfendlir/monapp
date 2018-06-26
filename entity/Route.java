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

@Entity
@Table(name = "ROUTE")
public class Route {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;

	@NotNull
	@Column(name="DIRECTION")
	private int[] direction;

	@OneToOne
	@JoinColumn(name = "SCENARIO_ID")
	private Scenario scenario;
	
	public Route() {
		super();
	}

	public Route(int id, @NotNull int[] direction, Scenario scenario) {
		super();
		this.id = id;
		this.direction = direction;
		this.scenario = scenario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int[] getDirection() {
		return direction;
	}

	public void setDirection(int[] direction) {
		this.direction = direction;
	}

	public Scenario getScenario() {
		return scenario;
	}

	public void setScenario(Scenario scenario) {
		this.scenario = scenario;
	}

}