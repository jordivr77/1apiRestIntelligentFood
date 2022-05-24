package com.intelligentFood.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intelligentFood.model.Alimento;
import com.intelligentFood.model.Categoria;

@Transactional
@Repository
public interface AlimentoRepository extends JpaRepository<Alimento, Long> {
	
	public List<Alimento> findByCategoria(Categoria categoria);

}
