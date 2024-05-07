package com.usura.mgr.controller;

import com.usura.mgr.dto.EstudianteDto;

public class CrearEstudianteResponse {
    private EstudianteDto estudianteDto;
    private String mensaje;

    // Constructor, getters y setters
    public CrearEstudianteResponse(EstudianteDto estudianteDto, String mensaje) {
        this.estudianteDto = estudianteDto;
        this.mensaje = mensaje;
    }

    public EstudianteDto getEstudianteDto() {
        return estudianteDto;
    }

    public void setEstudianteDto(EstudianteDto estudianteDto) {
        this.estudianteDto = estudianteDto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
