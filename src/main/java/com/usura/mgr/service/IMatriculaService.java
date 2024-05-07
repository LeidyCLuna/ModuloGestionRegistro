package com.usura.mgr.service;

import com.usura.mgr.dto.MatriculaDto;

public interface IMatriculaService {

    MatriculaDto crearMatricula(MatriculaDto matriculaDto);
    MatriculaDto buscarMatricula(Integer idMatriculaDto);
}
