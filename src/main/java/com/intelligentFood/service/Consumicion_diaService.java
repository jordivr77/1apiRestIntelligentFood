package com.intelligentFood.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intelligentFood.model.Consumicion_dia;
import com.intelligentFood.repository.Consumicion_diaRepository;

@Service
public class Consumicion_diaService {

	@Autowired
	private Consumicion_diaRepository consumicion_diaRepository;

	public void guardarConsumicion_dia(Consumicion_dia consumicion_dia) {
		consumicion_diaRepository.save(consumicion_dia);
	}

	// Obtenemos TODOS los registros que tenemos en la BD
	public List<Consumicion_dia> obtenerTodas() {
		return consumicion_diaRepository.findAll();
	}

	public Optional<Consumicion_dia> obtenerConsumicion_dia(Long id) {
		return consumicion_diaRepository.findById(id);
	}

	// Método que nos permita actualizar el recurso
	// Cuando JPA encuentra una entidad que ya esté an la BD ACTUALIZA directamente
	// Si no la encuentra la crea y la inserta autom.
	public void actualizar(Consumicion_dia consumicion_dia) {
		consumicion_diaRepository.save(consumicion_dia);
	}
	
	// A partir del id sabremos el registro a eliminar
	public void eliminar(Long id) {
		consumicion_diaRepository.deleteById(id);
	}
	
}
