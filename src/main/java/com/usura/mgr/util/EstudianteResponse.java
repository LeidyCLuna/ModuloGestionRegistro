package com.usura.mgr.util;

import com.usura.mgr.dto.EstudianteDto;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EstudianteResponse {
    private String mensaje;
    private EstudianteDto estudianteDto;
}
