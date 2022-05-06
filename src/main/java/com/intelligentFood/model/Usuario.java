package com.intelligentFood.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Usuario {
	
	@Id
	@GeneratedValue
	private Long id;
	private String nombre;
	private String apellidos;
	private String email;
	private String password;
	private int edad;
	private Double peso;
	private Double altura;
	private String sexo;
	private String tipo;
	
	@OneToMany(mappedBy = "usuario")
	private List<Dia> dias;
	
	@OneToMany(mappedBy = "usuario")
	private List<Receta> recetas;
	
	
	
	public Usuario() {
	}
	

	
}
