package com.pet.clinic.home.data;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pet.clinic.home.model.pojo.HomeMascota;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetTypeRepository extends JpaRepository<HomeMascota, Long> {
//    List<HomeMascota> findByName(String shortDescription);
}
