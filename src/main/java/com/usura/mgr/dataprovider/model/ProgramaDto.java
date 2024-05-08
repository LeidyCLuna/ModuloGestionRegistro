package com.usura.mgr.dataprovider.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProgramaDto {
    private int  idPrograma;
    private String nombre;
    private String titulo;
    private int cretidos;
    private int semestres;
    private String registroMen;
}
