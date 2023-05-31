package com.pet.clinic.buscador.controllers;

import com.pet.clinic.buscador.enums.ResponseMessageEnum;
import com.pet.clinic.buscador.pojos.ResponsePojo;
import com.pet.clinic.buscador.services.IPropietarioService;
import com.pet.clinic.buscador.services.ITipoMascotaService;
import lombok.AllArgsConstructor;
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
@RequestMapping("/pet-clinic")
public class PropietarioController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PropietarioController.class);

    private ITipoMascotaService iTipoMascotaService;
    private IPropietarioService iPropietarioService;
    private ResponsePojo responsePojo;

    @GetMapping("/list-tipo-mascota")
    public ResponseEntity<ResponsePojo> getTiposMascotas(){

        responsePojo = iTipoMascotaService.getTipoDeMascota();
        ResponseEntity<ResponsePojo> responsePojoResponseEntity = null;

         try {
             if (responsePojo.getMessages().equals(ResponseMessageEnum.MESSAGE_OK_ENUM.toString())){
                  responsePojoResponseEntity =  ResponseEntity.status(HttpStatus.FOUND).body(responsePojo);
             }else {
                 responsePojoResponseEntity = ResponseEntity.status(HttpStatus.NO_CONTENT).body(responsePojo);
             }
         }catch (Exception e){
             LOGGER.error("Error tipo mascota: ",e.getCause().getMessage());
         }finally {
             LOGGER.info("getTiposMascotas");
         }
        return responsePojoResponseEntity;
    }

    @GetMapping("/list-propietarios")
    public ResponseEntity<ResponsePojo> getPropietarios(){

        ResponseEntity<ResponsePojo> responsePojoResponseEntity = null;
        responsePojo = iPropietarioService.getListPropietario();
        try {
            if (responsePojo.getMessages().equals(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages())) {
                responsePojoResponseEntity = ResponseEntity.status(HttpStatus.FOUND).body(responsePojo);
            } else {
                responsePojoResponseEntity = ResponseEntity.status(HttpStatus.NO_CONTENT).body(responsePojo);
            }
        }catch (Exception e){
            LOGGER.error("Error Lista Propietarios: ", e.getCause().getMessage());
        }finally {
            LOGGER.info("Lista getPropietarios");
        }
        return responsePojoResponseEntity;
    }

    @GetMapping("/list-propietario")
    public ResponseEntity<ResponsePojo> getPropietario(@RequestParam("propietarioId") String propietarioId){

        ResponseEntity<ResponsePojo> responsePojoResponseEntity = null;
        responsePojo = iPropietarioService.findPropietarioById(Long.parseLong(propietarioId));
        try {
            if (responsePojo.getMessages().equals(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages())) {
                responsePojoResponseEntity = ResponseEntity.status(HttpStatus.FOUND).body(responsePojo);
            } else {
                responsePojoResponseEntity = ResponseEntity.status(HttpStatus.NO_CONTENT).body(responsePojo);
            }
        }catch (Exception e){
            LOGGER.error("Error Obtener Propietario: ", e.getCause().getMessage());
        }
        finally {
            LOGGER.info("getPropietario");
        }
        return responsePojoResponseEntity;
    }

}
