package com.usura.mgr.service;

import com.usura.mgr.dto.ProgramaDto;

public interface IProgramaService {

    ProgramaDto crearPrograma(ProgramaDto programaDto);
    ProgramaDto buscarPrograma(Integer idProgramaDto);
}
