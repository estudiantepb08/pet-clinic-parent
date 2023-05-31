package com.pet.clinic.buscador.controllers;

import com.pet.clinic.buscador.enums.ResponseMessageEnum;
import com.pet.clinic.buscador.pojos.ResponsePojo;
import com.pet.clinic.buscador.services.IMascotaService;
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
@RequestMapping("/pet-clinic-mascota")
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

}
