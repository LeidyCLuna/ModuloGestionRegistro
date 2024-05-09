package com.usura.mgr.service.impl;

import com.usura.mgr.dataprovider.client.ISgaClient;
import com.usura.mgr.dto.EstudianteDto;
import com.usura.mgr.msgbroker.RabbitQueueSender;
import com.usura.mgr.repository.IEstudianteRepository;
import com.usura.mgr.service.IEstudianteService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EstudianteServiceimpl implements IEstudianteService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EstudianteServiceimpl.class);

    private final IEstudianteRepository iEstudianteRepository;
    private final ISgaClient iSgaClient;

    @Autowired
    RabbitQueueSender rabbitQueueSender;

    @Override
    public EstudianteDto enviarEstudiante(EstudianteDto estudianteDto) {
        try {
            EstudianteDto respuesta = consultarEstudiante(estudianteDto.getDocumento());
            if (respuesta == null) {
                rabbitQueueSender.send(estudianteDto);
                LOGGER.info("El estudiante es enviado a la rabbitMq para su creacion");
                return estudianteDto;
            } else {
                LOGGER.info("El estudiante ya existe");
               return null;
            }
        } catch (Exception ex) {
            throw new RuntimeException("Ocurrió un error al momento de encolar la solicitud de registro");
        }
    }

    @Override
    public EstudianteDto consultarEstudiante(String documento) {
        try {
            ResponseEntity<EstudianteDto> respuesta = iSgaClient.consultarEstudiante(documento);
            if (respuesta.getBody() == null) {
                LOGGER.info("El estudiante aun no existe");
                return null;
            } else {
                LOGGER.info("El estudiante ya existe");
                return respuesta.getBody();
            }
        } catch (Exception ex) {
            LOGGER.error("Ocurrió una excepción al consultar el estudiante", ex);
            throw new RuntimeException("Ocurrió un error al consultar el estudiante");
        }
    }
}
