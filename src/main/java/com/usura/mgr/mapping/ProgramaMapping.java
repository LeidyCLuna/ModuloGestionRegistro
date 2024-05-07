package com.usura.mgr.mapping;

import com.usura.mgr.dto.ProgramaDto;
import com.usura.mgr.entity.ProgramaEntity;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProgramaMapping {
    public ProgramaEntity programaDtoToProgramaEntity(
            ProgramaDto programaDto) {
        return ProgramaEntity.builder()
                .idprograma(programaDto.getIdPrograma())
                .nombre(programaDto.getNombre())
                .titulo(programaDto.getTitulo())
                .cretidos(programaDto.getCretidos())
                .registroMen(programaDto.getRegistroMen())
                .semestres(programaDto.getSemestres())
                .build();
    }

    public ProgramaDto programaEntityToProgramaDTO(
            ProgramaEntity programaEntity) {
        return ProgramaDto.builder()
                .idPrograma(programaEntity.getIdprograma())
                .nombre(programaEntity.getNombre())
                .titulo(programaEntity.getTitulo())
                .cretidos(programaEntity.getCretidos())
                .registroMen(programaEntity.getRegistroMen())
                .semestres(programaEntity.getSemestres())
                .build();
    }

}
