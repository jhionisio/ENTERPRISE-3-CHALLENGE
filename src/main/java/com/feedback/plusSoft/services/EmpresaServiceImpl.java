package com.feedback.plusSoft.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedback.plusSoft.models.Empresa;
import com.feedback.plusSoft.repository.EmpresaRepository;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    private EmpresaRepository repository;

    @Override
    public void create(Empresa empresa) {
        repository.save(empresa);
    }

    @Override
    public List<Empresa> findAll() {
        return repository.findAll();
    }

    @Override
    public Empresa findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void update(Long id, Empresa empresa) {
        empresa.setId(id);
        repository.save(empresa);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
