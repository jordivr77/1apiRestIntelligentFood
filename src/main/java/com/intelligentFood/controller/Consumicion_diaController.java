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

import com.intelligentFood.model.Consumicion_dia;
import com.intelligentFood.service.Consumicion_diaService;

@RestController
public class Consumicion_diaController {

	Logger logger = LoggerFactory.getLogger(Consumicion_diaController.class);

	@Autowired
	private Consumicion_diaService consumicion_diaService;

	// Tipo de petición POST para crear y almacenar un recurso
	@PostMapping("/api/consumiciondias")
	public Consumicion_dia guardarConsumicion_dia(@RequestBody Consumicion_dia consumicion_dia) {
		logger.info("Consumición día registro: {}", consumicion_dia);
		consumicion_diaService.guardarConsumicion_dia(consumicion_dia);
		return consumicion_dia;
	}

	// GET --> Obtener un recurso una lista
	@GetMapping("/api/consumiciondias")
	public List<Consumicion_dia> obtener() {
		return consumicion_diaService.obtenerTodas();
	}
	

	// Con el @PathVariable le decimos cuál es el nombre del parámetro que va a
	// venir en la petición y su tipo de dato
	@GetMapping("/api/consumiciondias/{id}")
	public Optional<Consumicion_dia> obtenerConsumicion_dia(@PathVariable("id") Long id) {
		return consumicion_diaService.obtenerConsumicion_dia(id);
	}

	// Va a mapearse con un método PUT
	// Va a venir un objeto desde el cliente
	@PutMapping("/api/consumiciondias")
	public void actualizarConsumicion_dia(@RequestBody Consumicion_dia consumicion_dia) {
		consumicion_diaService.actualizar(consumicion_dia);
	}
	
	// Declaramos que el parámetro que nos viene, tiene el nombre de id
	@DeleteMapping("/api/consumiciondias/{id}")
	public void eliminar(@PathVariable("id") Long id) {
		consumicion_diaService.eliminar(id);
	}

}
