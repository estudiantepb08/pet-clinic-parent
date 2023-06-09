package com.pet.clinic.buscador.controllers;

import com.pet.clinic.buscador.enums.ResponseMessageEnum;
import com.pet.clinic.buscador.pojos.PropietarioRequestPojo;
import com.pet.clinic.buscador.pojos.ResponsePojo;
import com.pet.clinic.buscador.services.IPropietarioService;
import com.pet.clinic.buscador.services.ITipoMascotaService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@AllArgsConstructor
//@RequestMapping("/v1/pet-clinic")
@RequestScope
public class PropietarioController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropietarioController.class);

    private ITipoMascotaService iTipoMascotaService;
    private IPropietarioService iPropietarioService;
    private ResponsePojo responsePojo;

    @GetMapping("/tipo-mascotas")
    public ResponseEntity<ResponsePojo> getTiposMascotas(){

        ResponseEntity<ResponsePojo> responsePojoResponseEntity = null;
      //  responsePojo = null;

         try {
             responsePojo = iTipoMascotaService.getTipoDeMascota();

             if (responsePojo.getMessages().equals(ResponseMessageEnum.MESSAGE_OK_ENUM.toString())){
                  responsePojoResponseEntity =  ResponseEntity.status(HttpStatus.FOUND).body(responsePojo);
             }else {
                 responsePojoResponseEntity = ResponseEntity.status(HttpStatus.NO_CONTENT).body(responsePojo);
             }
         }catch (Exception e){
             LOGGER.error("Error tipo mascota: ",e.getCause().getMessage());
             responsePojoResponseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
         }finally {
             LOGGER.info("getTiposMascotas");
         }
        return responsePojoResponseEntity;
    }

    @GetMapping("/propietarios")
    public ResponseEntity<ResponsePojo> getPropietarios(){

        ResponseEntity<ResponsePojo> responsePojoResponseEntity = null;
       // responsePojo = null;
        try {
            responsePojo = iPropietarioService.getListPropietario();

            if (responsePojo.getMessages().equals(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages())) {
                responsePojoResponseEntity = ResponseEntity.status(HttpStatus.FOUND).body(responsePojo);
            } else {
                responsePojoResponseEntity = ResponseEntity.status(HttpStatus.NO_CONTENT).body(responsePojo);
            }
        }catch (Exception e){
            LOGGER.error("Error Lista Propietarios: ", e.getCause().getMessage());
            responsePojoResponseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }finally {
            LOGGER.info("Lista getPropietarios");
        }
        return responsePojoResponseEntity;
    }

    @GetMapping("/propietarios/{propietarioId}")
    public ResponseEntity<ResponsePojo> getPropietario(@PathVariable String propietarioId){

        ResponseEntity<ResponsePojo> responsePojoResponseEntity = null;
       // responsePojo = null;
        try {
            responsePojo = iPropietarioService.findPropietarioById(Long.parseLong(propietarioId));

            if (responsePojo.getMessages().equals(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages())) {
                responsePojoResponseEntity = ResponseEntity.status(HttpStatus.FOUND).body(responsePojo);
            } else {
                responsePojoResponseEntity = ResponseEntity.status(HttpStatus.NO_CONTENT).body(responsePojo);
            }
        }catch (Exception e){
            LOGGER.error("Error Obtener Propietario: ", e.getCause().getMessage());
            responsePojoResponseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        finally {
            LOGGER.info("getPropietario");
        }
        return responsePojoResponseEntity;
    }

    @PostMapping("/propietarios")
    public ResponseEntity<ResponsePojo> savePropietario(@RequestBody PropietarioRequestPojo propietarioRequestPojo){

        ResponseEntity<ResponsePojo> responsePojoResponseEntity = null;
        //responsePojo = null;
        responsePojo = iPropietarioService.savePropietario(propietarioRequestPojo);

        try{
            if(responsePojo.getMessages().equals(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages())){
                responsePojoResponseEntity = ResponseEntity.status(HttpStatus.CREATED).body(responsePojo);
            }else{
                responsePojoResponseEntity = ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(responsePojo);
            }
        }catch (Exception e){
            LOGGER.error("Error al guardar el propietario", e.getCause().getMessage());
            responsePojoResponseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }finally {
            LOGGER.info("savePropietario");
        }
        return responsePojoResponseEntity;
    }

    @PutMapping("/propietarios/numero/{requestPropietarioId}")
    public ResponseEntity<ResponsePojo> updatePropietario(@RequestBody PropietarioRequestPojo propietarioRequestPojo,
                                                          @PathVariable Long requestPropietarioId){

        ResponseEntity<ResponsePojo> responsePojoResponseEntity = null;
        try{
            responsePojo = iPropietarioService.findPropietarioById(requestPropietarioId);
            if (responsePojo.getMessages().equals(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages())){

                responsePojo = iPropietarioService.updatePropietario(propietarioRequestPojo, requestPropietarioId);
                responsePojoResponseEntity = ResponseEntity.status(HttpStatus.CREATED).body(responsePojo);

            }else{
                responsePojoResponseEntity = ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(responsePojo);
            }
        }catch (Exception e){
            LOGGER.error("Error Actualizar datos del propietario: ", e.getCause().getMessage());
            responsePojoResponseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }finally {
            LOGGER.info("updatePropietario");
        }
        return responsePojoResponseEntity;
    }

    @DeleteMapping("/propietarios/{propietarioId}")
    public ResponseEntity<ResponsePojo> eliminarPropietario(@PathVariable Long propietarioId){

        ResponseEntity<ResponsePojo> responsePojoResponseEntity = null;
        try{
           // responsePojo = null;
            responsePojo = iPropietarioService.deletePropietario(propietarioId);
            if(responsePojo.getMessages().equals(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages())){
                responsePojoResponseEntity = ResponseEntity.status(HttpStatus.OK).body(responsePojo);
            }else{
                responsePojoResponseEntity = ResponseEntity.status(HttpStatus.NO_CONTENT).body(responsePojo);
            }
        }catch (Exception e){
            LOGGER.error("Error Eliminar datos del propietario: ", e.getCause().getMessage());
            responsePojoResponseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responsePojo);
        }finally {
            LOGGER.info("eliminarPropietario");
        }
        return responsePojoResponseEntity;
    }
}
