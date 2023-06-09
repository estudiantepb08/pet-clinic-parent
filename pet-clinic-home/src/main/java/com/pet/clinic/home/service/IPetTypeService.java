package com.pet.clinic.home.service;

import com.pet.clinic.home.model.pojo.HomeMascota;
import java.util.List;

public interface IPetTypeService {
    HomeMascota getPetType(Long petTypeId);
    List<HomeMascota> getPetTypes();
}
