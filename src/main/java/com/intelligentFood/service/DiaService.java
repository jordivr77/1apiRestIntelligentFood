package com.intelligentFood.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intelligentFood.model.Dia;
import com.intelligentFood.repository.DiaRepository;

@Service
public class DiaService {

	@Autowired
	private DiaRepository diaRepository;

	public void guardarDia(Dia dia) {
		diaRepository.save(dia);
	}

	// Obtenemos TODOS los registros que tenemos en la BD
	public List<Dia> obtenerTodos() {
		return diaRepository.findAll();
	}

	public Optional<Dia> obtenerDia(Long id) {
		return diaRepository.findById(id);
	}

	// Método que nos permita actualizar el recurso
	// Cuando JPA encuentra una entidad que ya esté an la BD ACTUALIZA directamente
	// Si no la encuentra la crea y la inserta autom.
	public void actualizar(Dia dia) {
		diaRepository.save(dia);
	}
	
	// A partir del id sabremos el registro a eliminar
	public void eliminar(Long id) {
		diaRepository.deleteById(id);
	}
	
}
