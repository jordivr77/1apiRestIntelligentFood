package com.intelligentFood.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intelligentFood.model.Alimento;

@Transactional
@Repository
public interface AlimentoRepository extends JpaRepository<Alimento, Long> {

}