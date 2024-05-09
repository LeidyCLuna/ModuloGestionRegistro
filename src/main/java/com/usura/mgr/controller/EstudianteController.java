package com.usura.mgr.controller;

import com.usura.mgr.dto.EstudianteDto;
import com.usura.mgr.dto.MatriculaDto;
import com.usura.mgr.service.IEstudianteService;
import com.usura.mgr.util.EstudianteResponse;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
@RequestMapping("/mgr")
public class EstudianteController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EstudianteController.class);
    private final IEstudianteService iEstudianteService;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "ok. se envio corectamente el estudiante", response = EstudianteDto.class),
            @ApiResponse(code = 400, message = "no llenaste los datos correctamente", response = String.class),
            @ApiResponse(code = 500, message = "error inesperado del sistema")
    })

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EstudianteResponse> guardarEsudiante(@RequestBody @Validated EstudianteDto estudianteDto) {
        EstudianteDto estudianteResponse = iEstudianteService.enviarEstudiante(estudianteDto);
        try {
            if (estudianteResponse != null) {
                return ResponseEntity.status(HttpStatus.OK).body(new EstudianteResponse( "Estudiante registrado exitosamente", estudianteDto));
            } else
                return ResponseEntity.status(HttpStatus.OK).body(new EstudianteResponse( "El estudiante ya se encuentra registrado",estudianteDto));

        } catch (Exception e) {
            LOGGER.error("Error al convertir el objeto EstudianteDto a formato JSON.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new EstudianteResponse("Error interno del servidor al procesar la solicitud", null));
        }
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EstudianteResponse> consultarEstudiante(@RequestParam("documento") String documento) {
        try {
            EstudianteDto estudianteDto = iEstudianteService.consultarEstudiante(documento);
            if (estudianteDto != null) {
                return ResponseEntity.status(HttpStatus.OK).body(new EstudianteResponse("Estudiante encontrado", estudianteDto));
            } else
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new EstudianteResponse( "Estudiante no encontrado para el documento: " + documento, null));

        } catch (Exception e) {
            LOGGER.error("Error al consultar estudiante.", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new EstudianteResponse("Error interno del servidor al procesar la solicitud", null));
        }
    }
}

