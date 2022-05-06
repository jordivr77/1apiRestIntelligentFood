package com.intelligentFood.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intelligentFood.model.Receta;

@Transactional
@Repository
public interface RecetaRepository extends JpaRepository<Receta, Long> {

	
}
