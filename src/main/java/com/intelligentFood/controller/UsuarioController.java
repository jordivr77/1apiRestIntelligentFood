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

import com.intelligentFood.model.Usuario;
import com.intelligentFood.service.UsuarioService;


@RestController
public class UsuarioController {
	
	Logger logger = LoggerFactory.getLogger(UsuarioController.class);

	@Autowired
	private UsuarioService usuarioServicioService;
	

	
	// Tipo de petición POST para crear y almacenar un recurso
	@PostMapping("/api/usuarios")
	public Usuario guardarUsuario(@RequestBody Usuario usuario) {  // Conversión de JSON para que se asigne en un objeto java
		logger.info("Usuario registro: {}", usuario);
		usuarioServicioService.guardarUsuario(usuario);
		return usuario;
	}
	
	// GET --> Obtener rescurso, una lista
	@GetMapping("/api/usuarios")
	public List<Usuario> obtener(){
		return usuarioServicioService.obtenerTodos();
	}
	
	// Con el @PathVariable le decimos cuál es el nombre del parámetro que va a venir en la petición y su tipo de dato
	@GetMapping("/api/usuarios/{id}")
	public Optional<Usuario> obtenerUsuario(@PathVariable("id") Long id) {
		return usuarioServicioService.obtenerUsuario(id);
	}
	
	// Va a mapearse con un método PUT
	// Va a venir un objeto desde el cliente
	@PutMapping("/api/usuarios")
	public void actualizarUsuario(@RequestBody Usuario usuario) {
		usuarioServicioService.actualizar(usuario);
	}
	
	// Declaramos que el parámetro que nos viene, tiene el nombre de id
	@DeleteMapping("/api/usuarios/{id}")
	public void eliminar(@PathVariable("id") Long id) {
		usuarioServicioService.eliminar(id);
	}

}
