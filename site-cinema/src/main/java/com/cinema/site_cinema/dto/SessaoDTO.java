package com.cinema.site_cinema.dto;

import com.cinema.site_cinema.model.Filme;
import com.cinema.site_cinema.model.Sala;

import java.util.Date;

public class SessaoDTO {

    private Integer idSessao;
    private Filme filme;
    private Sala sala;
    private Date dataHora;

    // Construtores
    public SessaoDTO() {
    }

    public SessaoDTO(Integer idSessao, Filme filme, Sala sala, Date dataHora) {
        this.idSessao = idSessao;
        this.filme = filme;
        this.sala = sala;
        this.dataHora = dataHora;
    }

    // Getters e Setters
    public Integer getIdSessao() {
        return idSessao;
    }

    public void setIdSessao(Integer idSessao) {
        this.idSessao = idSessao;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }
}
