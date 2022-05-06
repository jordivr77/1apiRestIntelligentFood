package com.intelligentFood.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intelligentFood.model.Categoria;
import com.intelligentFood.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public void guardarCategoría(Categoria categoria) {
		categoriaRepository.save(categoria);
	}

	// Obtenemos TODOS los registros que tenemos en la BD
	public List<Categoria> obtenerTodos() {
		return categoriaRepository.findAll();
	}

	public Optional<Categoria> obtenerCategoria(Long id) {
		return categoriaRepository.findById(id);
	}

	// Método que nos permita actualizar el recurso
	// Cuando JPA encuentra una entidad que ya esté an la BD ACTUALIZA directamente
	// Si no la encuentra la crea y la inserta autom.
	public void actualizar(Categoria categoria) {
		categoriaRepository.save(categoria);
	}
	
	// A partir del id sabremos el registro a eliminar
	public void eliminar(Long id) {
		categoriaRepository.deleteById(id);
	}
}
