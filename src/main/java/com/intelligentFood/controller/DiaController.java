package com.intelligentFood.controller;

import java.time.LocalDate;
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
import com.intelligentFood.service.DiaService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class DiaController {

	Logger logger = LoggerFactory.getLogger(DiaController.class);

	@Autowired
	private DiaService diaService;

	// Tipo de petición POST para crear y almacenar un recurso
	@PostMapping("/api/dias")
	public Dia guardarDia(@RequestBody Dia dia) {
		logger.info("Dia registro: {}", dia);
		return diaService.guardarDia(dia);
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
	
	@GetMapping("/api/dia/hoy/{idUsuario}")
	public Dia obtenerDiaHoyUsuario(@PathVariable("idUsuario") Long idUsuario) {
		LocalDate fecha = LocalDate.now();
		Dia dia = diaService.obtenerDiaPorFechaUsuario(fecha, idUsuario);
		if (dia != null) {
			for (Consumicion_dia consumicion : dia.getConsumiciones_dias()) {
				consumicion.setDia(null);
			}
			dia.getUsuario().setDias(null);
		}
		return dia;
	}
	
	@PostMapping("/api/dia/nuevo/{idUsuario}")
	public void nuevoDia(@PathVariable("idUsuario") Long idUsuario) {
		LocalDate fecha = LocalDate.now();
		Dia dia = new Dia();
		dia.setFecha(fecha);
		diaService.guardarDia(dia, idUsuario);
	}
	
	@GetMapping("/api/dias/usuario/{idUsuario}")
	public List<Dia> obtenerDiasUsuario(@PathVariable("idUsuario") Long idUsuario) {
		List<Dia> dias = diaService.obtenerDiasPorUsuario(idUsuario);
		for (Dia dia : dias) {
			for (Consumicion_dia consumicion : dia.getConsumiciones_dias()) {
				consumicion.setDia(null);
			}
			dia.getUsuario().setDias(null);
		}
		return dias;
	}

}
