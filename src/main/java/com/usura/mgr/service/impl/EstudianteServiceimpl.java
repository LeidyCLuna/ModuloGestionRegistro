package com.usura.mgr.service.impl;

import com.usura.mgr.dataprovider.client.ISgaClient;
import com.usura.mgr.dto.EstudianteDto;
import com.usura.mgr.entity.EstudianteEntity;
import com.usura.mgr.mapping.EstudianteMapping;
import com.usura.mgr.msgbroker.RabbitQueueSender;
import com.usura.mgr.repository.IEstudianteRepository;
import com.usura.mgr.service.IEstudianteService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EstudianteServiceimpl implements IEstudianteService {

    private final IEstudianteRepository iEstudianteRepository;
    private final ISgaClient iSgaClient;

    @Autowired
    RabbitQueueSender rabbitQueueSender;

    @Override
    public EstudianteDto enviarEstudiante(EstudianteDto estudianteDto) {
        EstudianteDto respuesta = consultarEstudiante(estudianteDto.getDocumento());
        if (respuesta == null) {
            rabbitQueueSender.send(estudianteDto);
            return estudianteDto;
        } else {
            return null;
        }
    }

    @Override
    public EstudianteDto consultarEstudiante(String documento) {
        ResponseEntity<EstudianteDto> respuesta = iSgaClient.consultarEstudiante(documento);
        if (respuesta.getBody() == null) {
            return null;
        } else {
            return respuesta.getBody();
        }
    }



}
