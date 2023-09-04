package com.feedback.plusSoft.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feedback.plusSoft.models.Usuario;
import com.feedback.plusSoft.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public void create(Usuario usuario) {
        repository.save(usuario);
    }

    @Override
    public List<Usuario> findAll() {
        return repository.findAll();
    }

    @Override
    public Usuario findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void update(Long id, Usuario usuario) {
        usuario.setId(id);
        repository.save(usuario);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
