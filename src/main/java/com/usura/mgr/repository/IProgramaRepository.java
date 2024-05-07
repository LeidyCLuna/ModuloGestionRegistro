package com.usura.mgr.repository;


import com.usura.mgr.entity.ProgramaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProgramaRepository extends JpaRepository <ProgramaEntity, Integer> {
}
