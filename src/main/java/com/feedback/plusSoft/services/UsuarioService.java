package com.feedback.plusSoft.services;

import java.util.List;

import com.feedback.plusSoft.models.Usuario;

public interface UsuarioService {
    void create(Usuario usuario);

    List<Usuario> findAll();

    Usuario findById(Long id);

    void update(Long id, Usuario usuario);

    void deleteById(Long id);
}
