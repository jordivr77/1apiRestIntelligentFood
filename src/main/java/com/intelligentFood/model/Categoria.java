package com.intelligentFood.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Categoria {

	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	
	@OneToMany(mappedBy = "categoria")
	private List<Alimento> alimentos;
	
	@OneToMany(mappedBy = "categoria")
	private List<Receta> recetas;

	public Categoria() {
	}

}
