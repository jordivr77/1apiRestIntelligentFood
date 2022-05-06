package com.intelligentFood.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.intelligentFood.model.Dia;
import com.intelligentFood.service.DiaService;

@RestController
public class DiaController {

	Logger logger = LoggerFactory.getLogger(DiaController.class);

	@Autowired
	private DiaService diaService;

	// Tipo de petición POST para crear y almacenar un recurso
	@PostMapping("/api/dias")
	public Dia guardarDia(@RequestBody Dia dia) {
		logger.info("Dia registro: {}", dia);
		diaService.guardarDia(dia);
		return dia;
	}

	// GET --> Obtener un recurso una lista
	@GetMapping("/api/dias")
	public List<Dia> obtener() {
		return diaService.obtenerTodos();
	}

	// Con el @PathVariable le decimos cuál es el nombre del parámetro que va a
	// venir en la petición y su tipo de dato
	@GetMapping("/api/dias/{id}")
	public Optional<Dia> obtenerDia(@PathVariable("id") Long id) {
		return diaService.obtenerDia(id);
	}

	// Va a mapearse con un método PUT
	// Va a venir un objeto desde el cliente
	@PutMapping("/api/dias")
	public void actualizarDia(@RequestBody Dia dia) {
		diaService.actualizar(dia);
	}
	
	// Declaramos que el parámetro que nos viene, tiene el nombre de id
	@DeleteMapping("/api/dias/{id}")
	public void eliminar(@PathVariable("id") Long id) {
		diaService.eliminar(id);
	}

}
