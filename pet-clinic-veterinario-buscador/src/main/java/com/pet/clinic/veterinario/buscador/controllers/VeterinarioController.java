package com.pet.clinic.veterinario.buscador.controllers;



import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pet.clinic.veterinario.buscador.enums.ResponseMessageEnum;
import com.pet.clinic.veterinario.buscador.pojos.ResponsePojo;
import com.pet.clinic.veterinario.buscador.services.IEspecialidadService;
import com.pet.clinic.veterinario.buscador.services.IVeterinarioService;

@RestController
@AllArgsConstructor
@RequestMapping("/pet-clinic-veterinarios")
public class VeterinarioController {

    private static final Logger LOGGER = LoggerFactory.getLogger(VeterinarioController.class);

    private IEspecialidadService iEspecialidadService;
    private IVeterinarioService iVeterinarioService;
    private ResponsePojo responsePojo;

    @GetMapping("/list-especilidades")
    public ResponseEntity<ResponsePojo> getEspecialidades(){

        responsePojo = iEspecialidadService.getEspecialidad();
        ResponseEntity<ResponsePojo> responsePojoResponseEntity = null;

        try {
            if (responsePojo.getMessages().equals(ResponseMessageEnum.MESSAGE_OK_ENUM.toString())){
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

    @GetMapping("/list-veterinarios")
    public ResponseEntity<ResponsePojo> getVeterinario(){

        ResponseEntity<ResponsePojo> responsePojoResponseEntity = null;
        responsePojo = iVeterinarioService.getVeterinario();
        try {
            if (responsePojo.getMessages().equals(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages())) {
                responsePojoResponseEntity = ResponseEntity.status(HttpStatus.FOUND).body(responsePojo);
            } else {
                responsePojoResponseEntity = ResponseEntity.status(HttpStatus.NO_CONTENT).body(responsePojo);
            }
        }catch (Exception e){
            LOGGER.error("Error Veeteriario: ", e.getCause().getMessage());
        }finally {
            LOGGER.info("Lista getVeterinario");
        }
        return responsePojoResponseEntity;
    }

    @GetMapping("/list-veterinario")
    public ResponseEntity<ResponsePojo> getVeterinario(@RequestParam("veterinarioId") String veterinarioId){

        ResponseEntity<ResponsePojo> responsePojoResponseEntity = null;
        responsePojo = iVeterinarioService.findVeterinarioById(Long.parseLong(veterinarioId));
        try {
            if (responsePojo.getMessages().equals(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages())) {
                responsePojoResponseEntity = ResponseEntity.status(HttpStatus.FOUND).body(responsePojo);
            } else {
                responsePojoResponseEntity = ResponseEntity.status(HttpStatus.NO_CONTENT).body(responsePojo);
            }
        }catch (Exception e){
            LOGGER.error("Veterinario no encontrado: ", e.getCause().getMessage());
        }
        finally {
            LOGGER.info("getVeterinario");
        }
        return responsePojoResponseEntity;
    }

}