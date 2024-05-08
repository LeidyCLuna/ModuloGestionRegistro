package com.usura.mgr.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaMatricula;
    private ProgramaDto idPrograma;
    private EstudianteDto idEstudiante;
}
