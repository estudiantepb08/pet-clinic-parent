package com.pet.clinic.buscador.controllers;

import com.pet.clinic.buscador.enums.ResponseMessageEnum;
import com.pet.clinic.buscador.pojos.MascotaRequestPojo;
import com.pet.clinic.buscador.pojos.ResponsePojo;
import com.pet.clinic.buscador.services.IMascotaService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/pet-clinic-mascota")
@RequestScope
public class MascotaController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MascotaController.class);
    private IMascotaService iMascotaService;
    private ResponsePojo responsePojo;

    @GetMapping("/mascotas")
    public ResponseEntity<ResponsePojo> getMascotas(){

        ResponseEntity<ResponsePojo> responsePojoResponseEntity = null;
        responsePojo = iMascotaService.getMascota();
        try {
            if (responsePojo.getMessages().equals(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages())) {
                responsePojoResponseEntity = ResponseEntity.status(HttpStatus.FOUND).body(responsePojo);
            } else {
                responsePojoResponseEntity = ResponseEntity.status(HttpStatus.NO_CONTENT).body(responsePojo);
            }
        }catch (Exception e){
            LOGGER.error("Error List Mascota: ", e.getCause().getMessage());
        }finally {
            LOGGER.info("getMascotas");
        }
        return responsePojoResponseEntity;
    }

    @GetMapping("/mascota")
    public ResponseEntity<ResponsePojo> getMascotaPorId(@RequestParam("mascotaId") String mascotaId){

        ResponseEntity<ResponsePojo> responsePojoResponseEntity = null;
        responsePojo = iMascotaService.findMascotaById(Long.parseLong(mascotaId));
        try{
            if (responsePojo.getMessages().equals(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages())){
                responsePojoResponseEntity = ResponseEntity.status(HttpStatus.FOUND).body(responsePojo);
            }else {
                responsePojoResponseEntity = ResponseEntity.status(HttpStatus.NO_CONTENT).body(responsePojo);
            }
        }catch (Exception e){
            LOGGER.error("ERROR Obtener Mascota  Por Id: ", e.getCause().getMessage());
        }finally {
            LOGGER.info("getMascotaPorId");
        }
        return responsePojoResponseEntity;
    }

    @PostMapping("/mascota")
    public ResponseEntity<ResponsePojo> saveMascota(@RequestBody MascotaRequestPojo mascotaRequestPojo){

        ResponseEntity<ResponsePojo> responsePojoResponseEntity = null;
        try{
            responsePojo = iMascotaService.saveMascota(mascotaRequestPojo);
            if (responsePojo.getMessages().equals(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages())){
                responsePojoResponseEntity = ResponseEntity.status(HttpStatus.CREATED).body(responsePojo);
            }else {
                responsePojoResponseEntity = ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(responsePojo);
            }
        }catch (Exception e){
            LOGGER.error("Error en el metodo guardar: ", e.getCause().getMessage());
        }finally {
            LOGGER.info("saveMascota");
        }
        return responsePojoResponseEntity;
    }

    @PutMapping("/mascota/numero/{mascotaId}")
    public ResponseEntity<ResponsePojo> updateMascota(@RequestBody MascotaRequestPojo mascotaRequestPojo,
                                                      @PathVariable Long mascotaId){
        ResponseEntity<ResponsePojo> responsePojoResponseEntity = null;
        try{
            ResponsePojo responsePojoMasco = iMascotaService.findMascotaById(mascotaId);

            if (responsePojoMasco.getMessages().equals(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages())){

                responsePojo = iMascotaService.updateMascota(mascotaRequestPojo, mascotaId);

                if (responsePojo.getMessages().equals(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages())){
                    responsePojoResponseEntity = ResponseEntity.status(HttpStatus.CREATED).body(responsePojo);
                }else{
                    responsePojoResponseEntity = ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(responsePojo);
                }
            }else {
                responsePojoResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(responsePojo);
            }
        }catch (Exception e){
            LOGGER.error("Error en el metodo actualizar mascota");
        }finally {
            LOGGER.info("updateMascota");
        }
        return responsePojoResponseEntity;
    }

    @DeleteMapping("/mascota/{mascotaId}")
    public ResponseEntity<ResponsePojo> eliminarMascota(@PathVariable Long mascotaId){

        ResponseEntity<ResponsePojo> responsePojoResponseEntity = null;

        try {
            responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_NOT_FOUND_ENUM.getMessages());

            if (iMascotaService.deleteMascota(mascotaId)){
                responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
                responsePojoResponseEntity = ResponseEntity.status(HttpStatus.OK).body(responsePojo);
            }else{
                responsePojoResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(responsePojo);
            }

        }catch (Exception e){
            LOGGER.error("Error: en el metodo eliminar mascota", e.getCause().getMessage());
        }finally {
            LOGGER.info("eliminarMascota");
        }
        return responsePojoResponseEntity;
    }
}
