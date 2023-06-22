package com.pet.clinic.veterinario.buscador.services;

import com.pet.clinic.veterinario.buscador.enums.ResponseMessageEnum;
import com.pet.clinic.veterinario.buscador.models.dto.BuscarTodosLab;
import com.pet.clinic.veterinario.buscador.models.dto.VeterinarioDto;
import com.pet.clinic.veterinario.buscador.models.entity.Especialidad;
import com.pet.clinic.veterinario.buscador.models.entity.EspecialidadElastic;
import com.pet.clinic.veterinario.buscador.models.entity.Veterinario;
import com.pet.clinic.veterinario.buscador.models.entity.VeterinarioElastic;
import com.pet.clinic.veterinario.buscador.pojos.EspecialidadRequestPojo;
import com.pet.clinic.veterinario.buscador.pojos.VeterinariosRequestPojo;
import com.pet.clinic.veterinario.buscador.pojos.ResponsePojo;
import com.pet.clinic.veterinario.buscador.repository.DataAccessRepository;
import com.pet.clinic.veterinario.buscador.repository.IVererinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Service
public class VeterinariosServiceImpl implements IVeterinarioService {
    
    /*@Autowired
    IVererinarioRepository iVeterinarioRepository;]*/

	@Autowired
	DataAccessRepository iVeterinarioRepository;
	
	@Autowired
	ResponsePojo responsePojo;
	private List<VeterinarioElastic> veterinarios;

    @Override
	public ResponsePojo getVeterinario() {

		this.veterinarios = new ArrayList<>();

		iVeterinarioRepository.findAll().forEach(veterinarios::add); // pendiente repository
		if (veterinarios.isEmpty()) {
			responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_NOT_FOUND_ENUM.getMessages());
		} else {
			responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
			responsePojo.setData(this.veterinarios);
		}
	return responsePojo;
	}

	@Override
	public ResponsePojo findVeterinarioById(String veterinarioId) {
		this.veterinarios = new ArrayList<>();

		Optional<VeterinarioElastic> optionalVeterionario = iVeterinarioRepository.findById(veterinarioId); // pendiente repository
		if (optionalVeterionario.isPresent()) {
			this.veterinarios.add(optionalVeterionario.get());
			responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
			responsePojo.setData(this.veterinarios);
		} else {
			responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_NOT_FOUND_ENUM.getMessages());
		}
		return responsePojo;
		}


		// revisar funcionamiento
	@Override
	public ResponsePojo saveVeterinario(VeterinariosRequestPojo veterinariosRequestPojo) {



		if(veterinariosRequestPojo != null && StringUtils.hasLength(veterinariosRequestPojo.getPrimerNombreVet().trim())
				|| (StringUtils.hasLength(veterinariosRequestPojo.getSegundoNombreVet().trim())
				|| StringUtils.hasLength(veterinariosRequestPojo.getSegundoApellidoVet().trim()))
				&& StringUtils.hasLength(veterinariosRequestPojo.getPrimerApellidoVet().trim())
				&& !veterinariosRequestPojo.getEspecialidad().getEspecialidadId().equals(0))
				{


				VeterinarioElastic veterinario = VeterinarioElastic.builder()
						.veterinarioId(veterinariosRequestPojo.getVeterinarioId())
						.primerNombreVet(veterinariosRequestPojo.getPrimerNombreVet().trim())
						.segundoNombreVet(veterinariosRequestPojo.getSegundoNombreVet().trim())
						.primerApellidoVet(veterinariosRequestPojo.getPrimerApellidoVet().trim())
						.segundoApellidoVet(veterinariosRequestPojo.getSegundoApellidoVet().trim())
						.especialidad(EspecialidadElastic.builder().codigoEspecialidad(veterinariosRequestPojo.getEspecialidad().getCodigoEspecialidad())
								.descripcionTipo(veterinariosRequestPojo.getEspecialidad().getDescripcionTipo()).tipoEspecialidad(veterinariosRequestPojo.getEspecialidad().getTipoEspecialidad()).build())
						.build();
					VeterinarioElastic saveVeterinario = iVeterinarioRepository.save(veterinario);

				if(saveVeterinario != null){
					responsePojo.setData(saveVeterinario);
					responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
				}
		}else{
			responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_NOT_FOUND_ENUM.getMessages());
		}

		return responsePojo;
	}

	@Override
	@Transactional
	public ResponsePojo updateVeterinario(VeterinariosRequestPojo veterinariosRequestPojo, String veterinarioId) {

		Optional<VeterinarioElastic> optionalVeterionarioup = iVeterinarioRepository.findById(veterinarioId);

		if (optionalVeterionarioup.isPresent()) {
			if (veterinariosRequestPojo != null && StringUtils.hasLength(veterinariosRequestPojo.getPrimerNombreVet().trim())
					|| (StringUtils.hasLength(veterinariosRequestPojo.getSegundoNombreVet().trim())
					|| StringUtils.hasLength(veterinariosRequestPojo.getSegundoApellidoVet().trim()))
					&& StringUtils.hasLength(veterinariosRequestPojo.getPrimerApellidoVet().trim())
					&& !veterinariosRequestPojo.getEspecialidad().getCodigoEspecialidad().equals(0)) {


				VeterinarioElastic veterinario = VeterinarioElastic.builder().id(veterinarioId)
						.veterinarioId(veterinariosRequestPojo.getVeterinarioId())
						.primerNombreVet(veterinariosRequestPojo.getPrimerNombreVet().trim())
						.segundoNombreVet(veterinariosRequestPojo.getSegundoNombreVet().trim())
						.primerApellidoVet(veterinariosRequestPojo.getPrimerApellidoVet().trim())
						.segundoApellidoVet(veterinariosRequestPojo.getSegundoApellidoVet().trim())
						.especialidad(EspecialidadElastic.builder().codigoEspecialidad(veterinariosRequestPojo.getEspecialidad().getCodigoEspecialidad())
								.descripcionTipo(veterinariosRequestPojo.getEspecialidad().getDescripcionTipo()).tipoEspecialidad(veterinariosRequestPojo.getEspecialidad().getTipoEspecialidad()).build())
						.build();

				VeterinarioElastic saveVeterinario = iVeterinarioRepository.save(veterinario);

				if (saveVeterinario != null) {
					responsePojo.setData(saveVeterinario);
					responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
				}
			} else {
				responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_NOT_FOUND_ENUM.getMessages());
			}
		}else{
			responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_NOT_FOUND_ENUM.getMessages());
		}

		return responsePojo;
	}

	@Override
	@Transactional
	public ResponsePojo updateVeterinarioPatch(VeterinariosRequestPojo veterinariosRequestPojo, String id) {
		Optional<VeterinarioElastic> optionalVeterinario = iVeterinarioRepository.findById(id);

		if (optionalVeterinario.isPresent()) {
			VeterinarioElastic veterinario = optionalVeterinario.get();


			if (veterinariosRequestPojo.getPrimerNombreVet() != null) {
				veterinario.setPrimerNombreVet(veterinariosRequestPojo.getPrimerNombreVet().trim());
			}
			if (veterinariosRequestPojo.getSegundoNombreVet() != null) {
				veterinario.setSegundoNombreVet(veterinariosRequestPojo.getSegundoNombreVet().trim());
			}
			if (veterinariosRequestPojo.getPrimerApellidoVet() != null) {
				veterinario.setPrimerApellidoVet(veterinariosRequestPojo.getPrimerApellidoVet().trim());
			}
			if (veterinariosRequestPojo.getSegundoApellidoVet() != null) {
				veterinario.setSegundoApellidoVet(veterinariosRequestPojo.getSegundoApellidoVet().trim());
			}
			if (veterinariosRequestPojo.getEspecialidad() != null &&
					veterinariosRequestPojo.getEspecialidad().getEspecialidadId() != null &&
					!veterinariosRequestPojo.getEspecialidad().getEspecialidadId().equals(0)) {
				veterinario.setEspecialidad(EspecialidadElastic.builder()
						.especialidadId(veterinariosRequestPojo.getEspecialidad().getEspecialidadId())
						.build());
			}

			VeterinarioElastic saveVeterinario = iVeterinarioRepository.save(veterinario);

			if (saveVeterinario != null) {
				responsePojo.setData(saveVeterinario);
				responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
			}
		} else {
			responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_NOT_FOUND_ENUM.getMessages());
		}

		return responsePojo;
	}

	@Override
	public ResponsePojo deleteVeterinario(String id) {

		if(id!= null ){
			Optional<VeterinarioElastic> existVet = iVeterinarioRepository.findById(id);
			if (existVet.isPresent()){
			iVeterinarioRepository.deleteById(existVet.get());
			responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
			responsePojo.setData(null);}
		else{
			responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_NOT_FOUND_ENUM.getMessages());
				responsePojo.setData(null);}
		}else{
			responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_NOT_FOUND_ENUM.getMessages());
			responsePojo.setData(null);}
		return responsePojo;
	}

	@Override
	public ResponsePojo getListarTodo(String buscar) {
		List<VeterinarioElastic> respuesta = iVeterinarioRepository.listBuscarTodoVet(buscar);
		if (respuesta.isEmpty()){
            responsePojo.setMessages(ResponseMessageEnum.MESSAGE_ERROR_NOT_FOUND_ENUM.getMessages());
            responsePojo.setData(null);

        }else{
                responsePojo.setMessages(ResponseMessageEnum.MESSAGE_OK_ENUM.getMessages());
                responsePojo.setData(respuesta);
        }
        return responsePojo;
	}
    
}
