package com.usura.mgr.service;

import com.usura.mgr.dto.EstudianteDto;

public interface IEstudianteService {

    EstudianteDto enviarEstudiante(EstudianteDto estudianteDto);
    EstudianteDto buscarEstudiante(String documento);
}
