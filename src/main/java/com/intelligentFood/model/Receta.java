package com.intelligentFood.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Receta {

	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	private double kcalorias;
	
	@ManyToOne
	private Usuario usuario;
	
	@ManyToOne
	private Categoria categoria;
	
	@OneToMany(mappedBy = "receta")
	private List<Consumicion_dia> consumiciones_dias;

	@ManyToMany(mappedBy = "recetas")
	private List<Alimento> alimentos = new ArrayList<>();
	public Receta() {
	}

}
