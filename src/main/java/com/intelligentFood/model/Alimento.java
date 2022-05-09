package com.intelligentFood.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	private int ingrediente;
	
	@ManyToOne
	private Categoria categoria;
	
	@OneToMany(mappedBy = "alimento")
	private List<Consumicion_dia> consumiciones_dias;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Receta> recetas = new ArrayList<>();

	public Alimento() {
	}

}
