package com.pet.clinic.buscador.services;

import com.pet.clinic.buscador.enums.ResponseMessageEnum;
import com.pet.clinic.buscador.models.dtos.BuscarTodoDto;
import com.pet.clinic.buscador.models.dtos.MascotaDto;
import com.pet.clinic.buscador.models.entity.Mascota;
import com.pet.clinic.buscador.models.entity.MascotaElastic;
import com.pet.clinic.buscador.models.entity.Propietario;
import com.pet.clinic.buscador.models.entity.PropietarioElastic;
import com.pet.clinic.buscador.models.entity.TipoMascota;
import com.pet.clinic.buscador.models.entity.TipoMascotaElastic;
import com.pet.clinic.buscador.pojos.MascotaRequestPojo;
import com.pet.clinic.buscador.pojos.ResponsePojo;
import com.pet.clinic.buscador.repository.DataAccessRepositoryOwners;
import com.pet.clinic.buscador.repository.DataAccessRepositoryPets;
import com.pet.clinic.buscador.repository.DataAccessRepositoryTypePets;
import com.pet.clinic.buscador.repository.IMascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class MascotaServiceImpl implements IMascotaService{

    /*@Autowired
    IMascotaRepository iMascotaRepository;*/
	
	@Autowired
	DataAccessRepositoryPets  iMascotaRepository;
	@Autowired
	DataAccessRepositoryOwners iPropietarioRepository;
	@Autowired
	DataAccessRepositoryTypePets iTipoMascotasRepository;
    @Autowired
    ResponsePojo responsePojo;
    private List<MascotaElastic> mascotaDtoList;

    @Override
    public ResponsePojo getMascota() {

        this.mascotaDtoList = new ArrayList<>();
        this.mascotaDtoList = iMascotaRepository.findAll();

        if(this.mascotaDtoList.isEmpty()){
            responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_NOT_FOUND_ENUM.getMessages());
        }else{
            responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
            responsePojo.setData(this.mascotaDtoList);
        }
        return responsePojo;
    }

    @Override
    public ResponsePojo findMascotaById(String mascotaId) {

        this.mascotaDtoList = new ArrayList<>();
        
        Optional<MascotaElastic> mascota = iMascotaRepository.findById(mascotaId);
        if (mascota.isEmpty()){
            responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_NOT_FOUND_ENUM.getMessages());
        }else{
            responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
            responsePojo.setData(mascota);
        }
        return this.responsePojo;
    }

    @Override
    public ResponsePojo saveMascota(MascotaRequestPojo mascota) {

        if (mascota != null){
        	Optional<PropietarioElastic> propietarioFound = iPropietarioRepository.findById(mascota.getPropietario().getId());
        	Optional<TipoMascotaElastic> tipoMascotaFound = iTipoMascotasRepository.findById(mascota.getTipoMascota().getId());
        	if(propietarioFound.isEmpty() || tipoMascotaFound.isEmpty()) {
                responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_CAMPOS.getMessages());
                responsePojo.setData(null);
        	}
            MascotaElastic saveMascota = MascotaElastic.builder().nombreMascota(mascota.getNombreMascota())
                    .fechaNacimiento(mascota.getFechaNacimiento()).tipoMascota(tipoMascotaFound.get())
                    .propietario(propietarioFound.get()).build();

            MascotaElastic responseMascota = iMascotaRepository.save(saveMascota);
            if (responseMascota != null){
                responsePojo.setData(responseMascota);
                responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
            }else {
                responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_CAMPOS.getMessages());
            }
        }
        return responsePojo;
    }

    @Override
    public ResponsePojo updateMascota(MascotaRequestPojo mascota, String mascotaId) {

        if (mascota != null){
        	Optional<MascotaElastic> mascotaFound = iMascotaRepository.findById(mascotaId);
        	Optional<PropietarioElastic> propietarioFound = iPropietarioRepository.findById(mascota.getPropietario().getId());
        	Optional<TipoMascotaElastic> tipoMascotaFound = iTipoMascotasRepository.findById(mascota.getTipoMascota().getId());
        	if(propietarioFound.isEmpty() || tipoMascotaFound.isEmpty() || mascotaFound.isEmpty()) {
                responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_CAMPOS.getMessages());
                responsePojo.setData(null);
        	}
            MascotaElastic saveMascota = MascotaElastic.builder().id(mascota.getMascotasId()).nombreMascota(mascota.getNombreMascota())
                    .fechaNacimiento(mascota.getFechaNacimiento()).tipoMascota(tipoMascotaFound.get())
                    .propietario(propietarioFound.get()).build();

            MascotaElastic responseMascota = iMascotaRepository.save(saveMascota);
            if (responseMascota != null){
                responsePojo.setData(responseMascota);
                responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
            }else {
                responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_CAMPOS.getMessages());
            }
        }
        return responsePojo;
    }

    @Override
    public Boolean deleteMascota(String mascotaId) {
        Optional<MascotaElastic> mascota = iMascotaRepository.findById(mascotaId);
        boolean response = false;
        if(mascota.isPresent()){
            response = iMascotaRepository.deleteById(mascota.get());
        }
        return response;
    }

    @Override
    public ResponsePojo getListarTodo(String buscar) {

        List<MascotaElastic> listBuscarTodo = iMascotaRepository.listBuscarTodo(buscar);

        if (listBuscarTodo.isEmpty()){
            responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_NOT_FOUND_ENUM.getMessages());
            responsePojo.setData(null);

        }else{
                responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
                responsePojo.setData(listBuscarTodo);
        }
        return responsePojo;
    }
}
