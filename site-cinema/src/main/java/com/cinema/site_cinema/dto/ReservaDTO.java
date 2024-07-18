package com.cinema.site_cinema.dto;

import com.cinema.site_cinema.model.Assento;
import com.cinema.site_cinema.model.Sessao;

import java.util.Date;

public class ReservaDTO {

    private Integer idReserva;
    private Sessao sessao;
    private Assento assento;
    private String nomeCliente;
    private Date dataReserva;

    // Construtores
    public ReservaDTO() {
    }

    public ReservaDTO(Integer idReserva, Sessao sessao, Assento assento, String nomeCliente, Date dataReserva) {
        this.idReserva = idReserva;
        this.sessao = sessao;
        this.assento = assento;
        this.nomeCliente = nomeCliente;
        this.dataReserva = dataReserva;
    }

    // Getters e Setters
    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public Assento getAssento() {
        return assento;
    }

    public void setAssento(Assento assento) {
        this.assento = assento;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Date getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(Date dataReserva) {
        this.dataReserva = dataReserva;
    }
}

