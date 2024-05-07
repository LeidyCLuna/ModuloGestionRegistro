package com.usura.mgr.repository;

import com.usura.mgr.entity.CursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICursoRepository extends JpaRepository <CursoEntity, Integer> {
}
