package com.intelligentFood.repository;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intelligentFood.model.Dia;
import com.intelligentFood.model.Usuario;

@Transactional
@Repository
public interface DiaRepository extends JpaRepository<Dia, Long> {
	public Dia findByFechaAndUsuario(LocalDate fecha, Usuario usuario);
	public List<Dia> findByUsuarioOrderByFechaDesc(Usuario usuario);
}
