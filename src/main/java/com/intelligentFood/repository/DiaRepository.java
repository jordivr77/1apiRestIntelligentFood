package com.intelligentFood.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intelligentFood.model.Dia;

@Transactional
@Repository
public interface DiaRepository extends JpaRepository<Dia, Long> {

}
