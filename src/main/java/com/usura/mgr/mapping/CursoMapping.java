package com.usura.mgr.mapping;

import com.usura.mgr.dto.CursoDto;
import com.usura.mgr.entity.CursoEntity;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CursoMapping {
    public CursoEntity cursoDtoToCursoEntity(
            CursoDto cursoDto) {
        return CursoEntity.builder()
                .idcurso(cursoDto.getIdCurso())
                .nombre(cursoDto.getNombre())
                .titulo(cursoDto.getTitulo())
                .horas(cursoDto.getHoras())
                .registroMen(cursoDto.getRegistroMen())
                .build();
    }

    public CursoDto cursoEntityToCursoDTO(
            CursoEntity cursoEntity) {
        return CursoDto.builder()
                .idCurso(cursoEntity.getIdcurso())
                .nombre(cursoEntity.getNombre())
                .titulo(cursoEntity.getTitulo())
                .horas(cursoEntity.getHoras())
                .registroMen(cursoEntity.getRegistroMen())
                .build();
    }

}
