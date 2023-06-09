package com.pet.clinic.home.service;

import com.pet.clinic.home.data.PetTypeRepository;
import com.pet.clinic.home.model.pojo.HomeMascota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetTypeServiceImpl implements IPetTypeService {
    @Autowired
    private PetTypeRepository repository;
    @Override
    public HomeMascota getPetType(Long petTypeId) {
        return repository.findById(petTypeId).orElse(null);
    }
    @Override
    public List<HomeMascota> getPetTypes() {
        List<HomeMascota> homeMascotas = repository.findAll();
        return homeMascotas.isEmpty() ? null : homeMascotas;
    }
}
