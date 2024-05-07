package com.usura.mgr.dto;

import lombok.*;

import java.util.Date;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatriculaDto {
    private int idMatricula;
    private int año;
    private int periodo;
    private int nivel;
    private Date fechaMatricula;
    private ProgramaDto idPrograma;
    private CursoDto idCurso;
    private EstudianteDto idEstudiante;
}
