package com.intelligentFood.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intelligentFood.model.Usuario;

@Transactional
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	// Obtener un registro por email --> Para la VALIDACIÓN del usuario
	Optional<Usuario> findByEmail(String email);
	
}
