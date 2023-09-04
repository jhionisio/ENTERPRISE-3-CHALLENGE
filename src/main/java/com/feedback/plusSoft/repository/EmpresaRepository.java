package com.feedback.plusSoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.feedback.plusSoft.models.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
