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

import com.intelligentFood.model.Categoria;
import com.intelligentFood.service.CategoriaService;

@RestController
public class CategoriaController {

	Logger logger = LoggerFactory.getLogger(CategoriaController.class);

	@Autowired
	private CategoriaService categoriaService;

	// Tipo de petición POST para crear y almacenar un recurso
	@PostMapping("/api/categorias")
	public Categoria guardarCategoria(@RequestBody Categoria categoria) {
		logger.info("Categoría registro: {}", categoria);
		categoriaService.guardarCategoría(categoria);
		return categoria;
	}

	// GET --> Obtener un recurso una lista
	@GetMapping("/api/categorias")
	public List<Categoria> obtener() {
		List<Categoria> listaCategorias = categoriaService.obtenerTodos();
		for (Categoria categoria : listaCategorias) {
			categoria.setAlimentos(null);
			categoria.setRecetas(null);
		}
		return listaCategorias;
	}

	// Con el @PathVariable le decimos cuál es el nombre del parámetro que va a
	// venir en la petición y su tipo de dato
	@GetMapping("/api/categorias/{id}")
	public Optional<Categoria> obtenerCategoria(@PathVariable("id") Long id) {
		return categoriaService.obtenerCategoria(id);
	}

	// Va a mapearse con un método PUT
	// Va a venir un objeto desde el cliente
	@PutMapping("/api/categorias")
	public void actualizarCategoria(@RequestBody Categoria categoria) {
		categoriaService.actualizar(categoria);
	}
	
	// Declaramos que el parámetro que nos viene, tiene el nombre de id
	@DeleteMapping("/api/categorias/{id}")
	public void eliminar(@PathVariable("id") Long id) {
		categoriaService.eliminar(id);
	}
}
