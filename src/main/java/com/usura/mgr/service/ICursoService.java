package com.usura.mgr.service;

import com.usura.mgr.dto.CursoDto;

public interface ICursoService {

    CursoDto crearCurso(CursoDto cursoDto);
    CursoDto buscarCurso(Integer idCursoDto);
}
