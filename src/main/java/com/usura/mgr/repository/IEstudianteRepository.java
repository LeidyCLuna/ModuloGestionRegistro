package com.usura.mgr.repository;

import com.usura.mgr.entity.EstudianteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstudianteRepository extends JpaRepository <EstudianteEntity, String> {
    EstudianteEntity findByDocumento(String documento);
}
