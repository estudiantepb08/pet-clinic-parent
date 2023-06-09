package com.pet.clinic.buscador.models.dtos;

import java.util.Date;

public interface BuscarTodoDto {

    String getPrimerNombre();
    String getSegundoNombre();
    String getPrimerApellido();
    String getSegundoApellido();
    String getTelefono();
    String getDireccion();
    String getCorreoElectronico();
    String getNombreMascota();
    Date getFechaNacimiento();
    String getTipoMascota();
}
