package com.intelligentFood.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intelligentFood.model.Alimento;
import com.intelligentFood.repository.AlimentoRepository;

@Service
public class AlimentoService {

	@Autowired
	private AlimentoRepository alimentoRepository;

	public void guardarAlimento(Alimento alimento) {
		alimentoRepository.save(alimento);
	}

	// Obtenemos TODOS los registros que tenemos en la BD
	public List<Alimento> obtenerTodos() {
		return alimentoRepository.findAll();
	}

	public Optional<Alimento> obtenerAlimento(Long id) {
		return alimentoRepository.findById(id);
	}

	// Método que nos permita actualizar el recurso
	// Cuando JPA encuentra una entidad que ya esté an la BD ACTUALIZA directamente
	// Si no la encuentra la crea y la inserta autom.
	public void actualizar(Alimento alimento) {
		alimentoRepository.save(alimento);
	}
	
	// A partir del id sabremos el registro a eliminar
	public void eliminar(Long id) {
		alimentoRepository.deleteById(id);
	}
}
