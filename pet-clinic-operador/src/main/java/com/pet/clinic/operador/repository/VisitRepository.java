package com.pet.clinic.operador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pet.clinic.operador.models.VisitModel;

public interface VisitRepository extends JpaRepository<VisitModel, Long> {

}
