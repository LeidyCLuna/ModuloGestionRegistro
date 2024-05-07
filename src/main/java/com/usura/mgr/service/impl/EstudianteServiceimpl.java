package com.usura.mgr.service.impl;

import com.usura.mgr.dto.EstudianteDto;
import com.usura.mgr.entity.EstudianteEntity;
import com.usura.mgr.mapping.EstudianteMapping;
import com.usura.mgr.msgbroker.RabbitQueueSender;
import com.usura.mgr.repository.IEstudianteRepository;
import com.usura.mgr.service.IEstudianteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EstudianteServiceimpl implements IEstudianteService {

    private final IEstudianteRepository iEstudianteRepository;

    @Autowired
    RabbitQueueSender rabbitQueueSender;

    @Override
    public EstudianteDto enviarEstudiante(EstudianteDto estudianteDto) {
        EstudianteDto consultaEstudianteDto = buscarEstudiante(estudianteDto.getDocumento());
        if (consultaEstudianteDto == null) {
            rabbitQueueSender.send(estudianteDto);
            return estudianteDto;
        } else {
            return null;
        }
    }

    @Override
    public EstudianteDto buscarEstudiante(String documento) {
        EstudianteEntity estudianteEntity = iEstudianteRepository.findByDocumento(documento);
        if (estudianteEntity != null) {
            return new EstudianteMapping().estudianteEntityToEstudianteDTO(estudianteEntity);
        } else {
            return null;
        }
    }

}
