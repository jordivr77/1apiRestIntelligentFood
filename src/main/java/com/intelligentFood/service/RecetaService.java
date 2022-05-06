package com.intelligentFood.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intelligentFood.model.Receta;
import com.intelligentFood.repository.RecetaRepository;

@Service
public class RecetaService {

	@Autowired
	private RecetaRepository recetaRepository;

	public void guardarReceta(Receta receta) {
		recetaRepository.save(receta);
	}

	// Obtenemos TODOS los registros que tenemos en la BD
	public List<Receta> obtenerTodas() {
		return recetaRepository.findAll();
	}

	public Optional<Receta> obtenerReceta(Long id) {
		return recetaRepository.findById(id);
	}

	// Método que nos permita actualizar el recurso
	// Cuando JPA encuentra una entidad que ya esté an la BD ACTUALIZA directamente
	// Si no la encuentra la crea y la inserta autom.
	public void actualizar(Receta receta) {
		recetaRepository.save(receta);
	}
	
	// A partir del id sabremos el registro a eliminar
	public void eliminar(Long id) {
		recetaRepository.deleteById(id);
	}
}
