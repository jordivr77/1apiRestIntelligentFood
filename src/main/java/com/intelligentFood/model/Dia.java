package com.intelligentFood.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Dia {

	@Id
	@GeneratedValue
	private Long id;
	private LocalDate fecha;
	
	@ManyToOne
	private Usuario usuario;
	
	@OneToMany(mappedBy = "dia")
	private List<Consumicion_dia> consumiciones_dias;

	public Dia() {
	}

}
