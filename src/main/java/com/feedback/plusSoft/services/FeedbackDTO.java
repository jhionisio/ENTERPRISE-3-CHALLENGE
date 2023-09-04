package com.feedback.plusSoft.services;

import java.util.Date;

public class FeedbackDTO {
    private Long id;
    private UsuarioDTO usuario;
    private EmpresaDTO empresa;
    private Date dataFeedback;
    private String comentario;
    private int classificacao;

    public FeedbackDTO(Long id, UsuarioDTO usuario, EmpresaDTO empresa, Date dataFeedback, String comentario,
            int classificacao) {
        this.id = id;
        this.usuario = usuario;
        this.empresa = empresa;
        this.dataFeedback = dataFeedback;
        this.comentario = comentario;
        this.classificacao = classificacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public EmpresaDTO getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaDTO empresa) {
        this.empresa = empresa;
    }

    public Date getDataFeedback() {
        return dataFeedback;
    }

    public void setDataFeedback(Date dataFeedback) {
        this.dataFeedback = dataFeedback;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }
}
