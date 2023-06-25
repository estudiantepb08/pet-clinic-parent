package com.pet.clinic.veterinario.buscador.services;


import com.pet.clinic.veterinario.buscador.pojos.ResponsePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class EspecialidadServiceImpl  {



   // @Override
   /* public ResponsePojo getEspecialidad() {

        List<Especialidad> especialidades = new ArrayList<>();

        iEspecialidadRepository.findAll().forEach(especialidades::add);
        if (especialidades.isEmpty()) {
            responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_NOT_FOUND_ENUM.getMessages());
        } else {
            responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
            responsePojo.setData(especialidades);
        }
        return responsePojo;
    }*/

   /* @Override
    public ResponsePojo findEspecialidadById(Long especialidadId) {

        Optional<Especialidad> optionalEspecilidad = iEspecialidadRepository.findById(especialidadId); // pendiente repository
        if (optionalEspecilidad.isPresent()) {
            responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
            responsePojo.setData(optionalEspecilidad.get());
        } else {
            responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_NOT_FOUND_ENUM.getMessages());
        }
        return responsePojo;
    }*/
}
