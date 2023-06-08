package com.pet.clinic.veterinario.buscador.controllers;



import com.pet.clinic.veterinario.buscador.pojos.VeterinariosRequestPojo;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/especilidades")
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

    @GetMapping
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

    @GetMapping("/veterinario")
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

    @GetMapping("/veterinario/todos")
    public ResponseEntity<ResponsePojo> getListBuscarTodo(@PathParam("buscar") String buscar){
        ResponseEntity<ResponsePojo> responsePojoResponseEntity = null;
        try{
            responsePojo = iVeterinarioService.getListarTodo(buscar);
            if (responsePojo.getMessages().equals(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages())){
                responsePojoResponseEntity = ResponseEntity.status(HttpStatus.FOUND).body(responsePojo);
            }else {
                responsePojoResponseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(responsePojo);
            }
        }catch (Exception e){
            LOGGER.error("Error en la busqueda por todos los campos", e.getCause().getMessage());
            responsePojoResponseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }finally {
            LOGGER.info("getListBuscarTodo");
        }
        return responsePojoResponseEntity;
    }

    @PostMapping
    public ResponseEntity<ResponsePojo> saveVeterinario(@RequestBody VeterinariosRequestPojo veterinarioRequestPojo) {

        ResponseEntity<ResponsePojo> responsePojoResponseEntity = null;
        responsePojo = iVeterinarioService.saveVeterinario(veterinarioRequestPojo);

        try{
            if(responsePojo.getMessages().equals(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages())){
                responsePojoResponseEntity = ResponseEntity.status(HttpStatus.CREATED).body(responsePojo);
            }else{
                responsePojoResponseEntity = ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(responsePojo);
            }
        }catch (Exception e){
            LOGGER.error("Error al guardar el veterinario",e.getCause().getMessage());
            responsePojoResponseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }finally {
            LOGGER.info("saveVeterinario");
        }
        return responsePojoResponseEntity;
    }

    @PutMapping ("/{VeterinarioId}")
    public ResponseEntity<ResponsePojo> updateVeterinario(@RequestBody VeterinariosRequestPojo veterinariosRequestPojo,
                                                            @PathVariable Long VeterinarioId){
        ResponseEntity<ResponsePojo>responsePojoResponseEntity = null;
        try{
            responsePojo = iVeterinarioService.findVeterinarioById(VeterinarioId);
            if(responsePojo.getMessages().equals(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages())){
                responsePojo = iVeterinarioService.updateVeterinario(veterinariosRequestPojo,VeterinarioId);
                responsePojoResponseEntity = ResponseEntity.status(HttpStatus.CREATED).body(responsePojo);
            }else{
                responsePojoResponseEntity = ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(responsePojo);
            }
        }catch (Exception e){
            LOGGER.error("Error al actualizar el veterinario",e.getCause().getMessage());
            responsePojoResponseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }finally {
            LOGGER.info("Fin de la actualizacion del veterinario");
        }
        return responsePojoResponseEntity;
    }

    @DeleteMapping("/{veterinarioId}")
    public ResponseEntity<ResponsePojo> eliminarVeterinario(@PathVariable Long veterinarioId) {

        ResponseEntity<ResponsePojo> responsePojoResponseEntity = null;

        try {

            responsePojo = iVeterinarioService.deleteVeterinario(veterinarioId);

            if (responsePojo.getMessages().equals(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages())) {
                responsePojoResponseEntity = ResponseEntity.status(HttpStatus.OK).body(responsePojo);
            } else {
                responsePojoResponseEntity = ResponseEntity.status(HttpStatus.OK).body(responsePojo);
            }

        } catch (Exception e) {

            LOGGER.error("Error Eliminar el veterinario: ", e.getCause().getMessage());
            responsePojoResponseEntity = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responsePojo);
        }
        return responsePojoResponseEntity;
    }

}