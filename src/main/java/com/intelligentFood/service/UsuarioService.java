package com.intelligentFood.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intelligentFood.model.Usuario;
import com.intelligentFood.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public void guardarUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);

	}

	// Obtenemos TODOS los registros que tenemos en la BD
	public List<Usuario> obtenerTodos() {
		return usuarioRepository.findAll();
	}

	public Optional<Usuario> obtenerUsuario(Long id) {
		return usuarioRepository.findById(id);
	}

	// Método que nos permita actualizar el recurso
	// Cuando JPA encuentra una entidad que ya esté an la BD ACTUALIZA directamente
	// Si no la encuentra la crea y la inserta autom.
	public void actualizar(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	// A partir del id sabremos el registro a eliminar
	public void eliminar(Long id) {
		usuarioRepository.deleteById(id);
	}

	// Obtenemos el usuario por su email (Filtro)
	public Optional<Usuario> findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}

}
