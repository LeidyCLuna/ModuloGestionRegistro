package com.usura.mgr.repository;


import com.usura.mgr.entity.MatriculaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMatriculaRepository extends JpaRepository<MatriculaEntity, Integer> {
}
