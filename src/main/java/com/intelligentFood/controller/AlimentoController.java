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

import com.intelligentFood.model.Alimento;
import com.intelligentFood.service.AlimentoService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AlimentoController {

	Logger logger = LoggerFactory.getLogger(AlimentoController.class);

	@Autowired
	private AlimentoService alimentoService;


	// Tipo de petición POST para crear y almacenar un recurso
	@PostMapping("/api/alimentos")
	public Alimento guardarAlimento(@RequestBody Alimento alimento) {
		logger.info("Alimento registro: {}", alimento);
		alimentoService.guardarAlimento(alimento);
		return alimento;
	}

	// GET --> Obtener un recurso una lista
	@GetMapping("/api/alimentos")
	public List<Alimento> obtener() {
		List<Alimento> listaAlimentos = alimentoService.obtenerTodos();
		for (Alimento alimento : listaAlimentos) {
			alimento.setConsumiciones_dias(null);
			alimento.setRecetas(null);
			alimento.getCategoria().setAlimentos(null);
			alimento.getCategoria().setRecetas(null);
			
		}
		return listaAlimentos;
		//return alimentoService.obtenerTodos();
	}

	// Con el @PathVariable le decimos cuál es el nombre del parámetro que va a
	// venir en la petición y su tipo de dato
	@GetMapping("/api/alimentos/{id}")
	public Optional<Alimento> obtenerAlimento(@PathVariable("id") Long id) {
		return alimentoService.obtenerAlimento(id);
	}

	
	// Va a mapearse con un método PUT
	// Va a venir un objeto desde el cliente
	@PutMapping("/api/alimentos")
	public void actualizarAlimento(@RequestBody Alimento alimento) {
		alimentoService.actualizar(alimento);
	}

	// Declaramos que el parámetro que nos viene, tiene el nombre de id
	@DeleteMapping("/api/alimentos/{id}")
	public void eliminar(@PathVariable("id") Long id) {
		alimentoService.eliminar(id);
	}

	@GetMapping("/api/alimentos/categorias/{idCategoria}")
	public List<Alimento> obtenerAlimentoPorCategoria(@PathVariable("idCategoria") Long idCategoria) {
		
		List<Alimento> listaAlimentos = alimentoService.findByCategoria(idCategoria);
		for (Alimento alimento : listaAlimentos) {
			alimento.setConsumiciones_dias(null);
			alimento.setRecetas(null);
			alimento.getCategoria().setAlimentos(null);
			alimento.getCategoria().setRecetas(null);
			
		}
		return listaAlimentos;
		
	}
}
