package com.pet.clinic.veterinario.buscador.controllers;

import com.pet.clinic.veterinario.buscador.enums.ResponseMessageEnum;
import com.pet.clinic.veterinario.buscador.pojos.ResponsePojo;
import com.pet.clinic.veterinario.buscador.services.IEspecialidadService;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/pet-clinic-especialidades")

public class EspecialidadController {
    private static final Logger LOGGER = LoggerFactory.getLogger(EspecialidadController.class);

    private IEspecialidadService iEspecialidadService;
    private ResponsePojo responsePojo;

    @GetMapping
    public ResponseEntity<ResponsePojo> getEspecialidades(){

        ResponseEntity<ResponsePojo> responsePojoResponseEntity = null;

        try {
            responsePojo = iEspecialidadService.getEspecialidad();

            if (responsePojo.getMessages().equals(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages())){
                responsePojoResponseEntity =  ResponseEntity.status(HttpStatus.FOUND).body(responsePojo);
            }else {
                responsePojoResponseEntity = ResponseEntity.status(HttpStatus.NO_CONTENT).body(responsePojo);
            }
        }catch (Exception e){
            LOGGER.error("Error en Especialidad: ",e.getCause().getMessage());
        }finally {
            LOGGER.info("getEspecialidad");
        }
        return responsePojoResponseEntity;
    }

    
    @GetMapping("/especialidades")
    public ResponseEntity<ResponsePojo> getEspecialidad(@RequestParam("especialidadId") String especialidadId){

        ResponseEntity<ResponsePojo> responsePojoResponseEntity = null;
        responsePojo = iEspecialidadService.findEspecialidadById(Long.parseLong(especialidadId));
        try {
            if (responsePojo.getMessages().equals(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages())) {
                responsePojoResponseEntity = ResponseEntity.status(HttpStatus.FOUND).body(responsePojo);
            } else {
                responsePojoResponseEntity = ResponseEntity.status(HttpStatus.NO_CONTENT).body(responsePojo);
            }
        }catch (Exception e){
            LOGGER.error("Epecialidad no encontrado: ", e.getCause().getMessage());
        }
        finally {
            LOGGER.info("getEspecialidad");
        }
        return responsePojoResponseEntity;
    }
}
