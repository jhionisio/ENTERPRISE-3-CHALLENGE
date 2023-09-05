package com.feedback.plusSoft.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.feedback.plusSoft.models.UserRegistrationForm;
import com.feedback.plusSoft.models.Usuario;
import com.feedback.plusSoft.repository.UsuarioRepository;

@RestController
public class AuthController {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public AuthController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping("/register")
    public String register(@RequestBody UserRegistrationForm registrationForm) {
        Usuario existingUser = usuarioRepository.findByUsername(registrationForm.getUsername());
        if (existingUser != null) {
            return "Registro falhou. Nome de usuário já existe.";
        }

        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(registrationForm.getUsername());
        novoUsuario.setPassword(registrationForm.getPassword());

        usuarioRepository.save(novoUsuario);

        return "Usuário cadastrado com sucesso: " + registrationForm.getUsername();
    }
}
