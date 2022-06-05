package com.intelligentFood.controller;

import java.util.ArrayList;
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

import com.intelligentFood.model.Consumicion_dia;
import com.intelligentFood.model.Dia;
import com.intelligentFood.service.Consumicion_diaService;
import com.intelligentFood.service.DiaService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST, RequestMethod.DELETE})
public class Consumicion_diaController {

	Logger logger = LoggerFactory.getLogger(Consumicion_diaController.class);

	@Autowired
	private Consumicion_diaService consumicion_diaService;
	@Autowired
	private DiaService diaService;

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
	
	@GetMapping("/api/consumiciondia/hoy/{id}")
	public List<Consumicion_dia> obtenerConsumicionesDiaHoy(@PathVariable("id") Long id ) {
		Dia hoy = diaService.obtenerDia(id);
		List<Consumicion_dia> consumicionesHoy = consumicion_diaService.obtenerPorDia(hoy);
		for (Consumicion_dia consumicion_dia : consumicionesHoy) {
			consumicion_dia.setDia(null);
			if (consumicion_dia.getAlimento() != null) {
				consumicion_dia.getAlimento().setCategoria(null);
				consumicion_dia.getAlimento().setConsumiciones_dias(null);
				consumicion_dia.getAlimento().setRecetas(null);
			} else {
				consumicion_dia.getReceta().setAlimentos(null);
				consumicion_dia.getReceta().setCategoria(null);
				consumicion_dia.getReceta().setConsumiciones_dias(null);
				consumicion_dia.getReceta().setUsuario(null);
			}
		}
		return consumicionesHoy;
	}
	
	@GetMapping("/api/consumicionesdia/usuario/{id}")
	public List<Consumicion_dia> obtenerConsumicionesPorUsuario(@PathVariable("id") Long id ) {
		List<Consumicion_dia> consumiciones = consumicion_diaService.obtenerTodas();
		List<Consumicion_dia> consumicionesUsuario = new ArrayList<>();
		for (Consumicion_dia consumicion_dia : consumiciones) {
			if (consumicion_dia.getDia().getUsuario().getId() == id) {
				consumicion_dia.getDia().setConsumiciones_dias(null);
				consumicion_dia.getDia().getUsuario().setDias(null);
				consumicion_dia.getDia().getUsuario().setRecetas(null);
				if (consumicion_dia.getAlimento() != null) {
					consumicion_dia.getAlimento().setCategoria(null);
					consumicion_dia.getAlimento().setConsumiciones_dias(null);
					consumicion_dia.getAlimento().setRecetas(null);
				} else {
					consumicion_dia.getReceta().setAlimentos(null);
					consumicion_dia.getReceta().setCategoria(null);
					consumicion_dia.getReceta().setConsumiciones_dias(null);
					consumicion_dia.getReceta().setUsuario(null);
				}
				consumicionesUsuario.add(consumicion_dia);
			}
		}
		return consumicionesUsuario;
	}
	
	

}
