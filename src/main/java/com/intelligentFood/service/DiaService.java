package com.intelligentFood.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intelligentFood.model.Dia;
import com.intelligentFood.model.Usuario;
import com.intelligentFood.repository.DiaRepository;
import com.intelligentFood.repository.UsuarioRepository;

@Service
public class DiaService {

	@Autowired
	private DiaRepository diaRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;

	public Dia guardarDia(Dia dia) {
		return diaRepository.save(dia);
	}
	
	public Dia guardarDia(Dia dia, Long idUsuario) {
		Usuario usuario = usuarioRepository.getById(idUsuario);
		dia.setUsuario(usuario);
		diaRepository.save(dia);
		return dia;
	}

	// Obtenemos TODOS los registros que tenemos en la BD
	public List<Dia> obtenerTodos() {
		return diaRepository.findAll();
	}

	public Dia obtenerDia(Long id) {
		return diaRepository.getById(id);
	}

	// Método que nos permita actualizar el recurso
	// Cuando JPA encuentra una entidad que ya esté an la BD ACTUALIZA directamente
	// Si no la encuentra la crea y la inserta autom.
	public void actualizar(Dia dia) {
		diaRepository.save(dia);
	}
	
	// A partir del id sabremos el registro a eliminar
	public void eliminar(Long id) {
		diaRepository.deleteById(id);
	}
	
	public Dia obtenerDiaPorFechaUsuario(LocalDate fehca, Long idUsuario) {
		Usuario usuario = usuarioRepository.getById(idUsuario);
		return diaRepository.findByFechaAndUsuario(fehca, usuario);
	}
	
	public List<Dia> obtenerDiasPorUsuario(Long idUsuario) {
		Usuario usuario = usuarioRepository.getById(idUsuario);
		return diaRepository.findByUsuarioOrderByFechaDesc(usuario);
	}
	
}
