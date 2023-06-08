package com.pet.clinic.operador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.*;

import com.pet.clinic.operador.dtos.SearchDto;
import com.pet.clinic.operador.models.VisitModel;

public interface VisitRepository extends JpaRepository<VisitModel, Long> {

	 @Query(value = "SELECT * FROM visit v" +
	            " WHERE (:cost IS NULL OR CAST(v.cost AS varchar) LIKE %:cost%) " +
	            " AND (:reason IS NULL OR v.reason LIKE %:reason%) " +
	            " AND (:status IS NULL OR v.status LIKE %:status%) " +
	            " AND (:isFirstVisit IS NULL OR CAST(v.is_first_visit AS varchar) LIKE %:isFirstVisit%)",
	            nativeQuery = true)
	    List<VisitModel> searchAll(@Param("cost") String cost,
	                               @Param("reason") String reason,
	                               @Param("status") String status,
	                               @Param("isFirstVisit") String isFirstVisit);

;
}
