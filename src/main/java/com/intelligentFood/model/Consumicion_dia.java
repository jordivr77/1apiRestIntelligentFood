package com.intelligentFood.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Consumicion_dia {

	@Id
	@GeneratedValue
	private Long id;
	private int gramos_alimento;
	private int gramos_receta;
	
	@ManyToOne
	private Receta receta;
	
	@ManyToOne
	private Alimento alimento;
	
	@ManyToOne
	private Dia dia;

	public Consumicion_dia() {
	}

}
