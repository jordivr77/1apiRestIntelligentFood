package com.intelligentFood.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intelligentFood.model.Consumicion_dia;

@Transactional
@Repository
public interface Consumicion_diaRepository extends JpaRepository<Consumicion_dia, Long> {

}
