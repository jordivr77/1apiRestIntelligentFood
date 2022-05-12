package com.intelligentFood.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.intelligentFood.model.Receta;
import com.intelligentFood.service.RecetaService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.POST})
public class RecetaController {

	Logger logger = LoggerFactory.getLogger(RecetaController.class);

	@Autowired
	private RecetaService recetaService;

	// Tipo de petición POST para crear y almacenar un recurso
	@PostMapping("/api/recetas")
	public Receta guardarReceta(@RequestBody Receta receta) {
		logger.info("Registro receta: {}", receta);
		recetaService.guardarReceta(receta);
		return receta;
	}

	// GET --> Obtener un recurso una lista
	@GetMapping("/api/recetas")
	public List<Receta> obtener() {
		return recetaService.obtenerTodas();
	}

	// Con el @PathVariable le decimos cuál es el nombre del parámetro que va a
	// venir en la petición y su tipo de dato
	@GetMapping("/api/recetas/{id}")
	public Optional<Receta> obtenerReceta(@PathVariable("id") Long id) {
		return recetaService.obtenerReceta(id);
	}

	// Va a mapearse con un método PUT
	// Va a venir un objeto desde el cliente
	@PutMapping("/api/recetas/")
	public void actualizarReceta(@RequestBody Receta receta) {
		recetaService.actualizar(receta);
	}
	
	// Declaramos que el parámetro que nos viene, tiene el nombre de id
	@DeleteMapping("/api/recetas/{id}")
	public void eliminar(@PathVariable("id") Long id) {
		recetaService.eliminar(id);
	}
	
}
