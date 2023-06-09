package com.pet.clinic.home.controller;

import com.pet.clinic.home.model.pojo.HomeMascota;
import com.pet.clinic.home.service.IPetTypeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class PetTypeController {

    private final IPetTypeService service = null;

    @GetMapping("/petType/{petTypeId}")
    public ResponseEntity<HomeMascota> getProduct(@PathVariable Long petTypeId) {
    	HomeMascota homeMascota = service.getPetType(petTypeId);
        if (homeMascota != null) {
            return ResponseEntity.ok(homeMascota);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/petTypes")
    public ResponseEntity<List<HomeMascota>> getPetTypes() {
        List<HomeMascota> homeMascotas = service.getPetTypes();
        if (homeMascotas != null) {
            return ResponseEntity.ok(homeMascotas);
        } else {
            return ResponseEntity.ok(Collections.emptyList());
        }
    }

}
