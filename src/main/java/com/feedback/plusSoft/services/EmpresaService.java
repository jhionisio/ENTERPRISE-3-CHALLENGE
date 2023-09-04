package com.feedback.plusSoft.services;

import java.util.List;

import com.feedback.plusSoft.models.Empresa;

public interface EmpresaService {
    void create(Empresa empresa);

    List<Empresa> findAll();

    Empresa findById(Long id);

    void update(Long id, Empresa empresa);

    void deleteById(Long id);
}
