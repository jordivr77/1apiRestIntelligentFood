package com.intelligentFood.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intelligentFood.model.Consumicion_dia;
import com.intelligentFood.model.Dia;
import com.intelligentFood.model.Usuario;

@Transactional
@Repository
public interface Consumicion_diaRepository extends JpaRepository<Consumicion_dia, Long> {
	public List<Consumicion_dia> findByDia(Dia dia);
}
