package com.intelligentFood.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Alimento {

	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	private String imagen;
	private int kcalorias;
	private boolean isIngrediente;
	
	@ManyToOne
	private Categoria categoria;
	
	@OneToMany(mappedBy = "alimento")
	private List<Consumicion_dia> consumiciones_dias;

	public Alimento() {
	}

}
