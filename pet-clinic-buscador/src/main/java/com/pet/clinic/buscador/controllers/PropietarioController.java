package com.pet.clinic.buscador.controllers;

import com.pet.clinic.buscador.models.entity.TipoMascota;
import com.pet.clinic.buscador.services.ITipoMascotaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@AllArgsConstructor
@RequestMapping("/pet-clinic")
public class PropietarioController {

    private ITipoMascotaService iTipoMascotaService;
    private final Map<String, Objects> RESPONSE = new HashMap<>();

    @GetMapping("/list-tipo-mascota")
    public ResponseEntity<?> getTiposMascotas(){

        return ResponseEntity.status(HttpStatus.FOUND).body(iTipoMascotaService.getTipoDeMascota());
    }

}
