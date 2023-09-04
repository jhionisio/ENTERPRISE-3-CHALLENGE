package com.feedback.plusSoft.services;

public class UsuarioDTO {
    private String nome;

    public UsuarioDTO(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
