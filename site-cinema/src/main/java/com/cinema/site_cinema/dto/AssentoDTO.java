package com.cinema.site_cinema.dto;

public class AssentoDTO {

    private int idAssento;
    private Integer idSala;  // Deve ser Integer se idSala em Sala for Integer
    private String numeroAssento;
    private boolean disponivel;

    public AssentoDTO() {
    }

    // Getters e Setters
    public int getIdAssento() {
        return idAssento;
    }

    public void setIdAssento(int idAssento) {
        this.idAssento = idAssento;
    }

    public Integer getIdSala() {
        return idSala;
    }

    public void setIdSala(Integer idSala) {
        this.idSala = idSala;
    }

    public String getNumeroAssento() {
        return numeroAssento;
    }

    public void setNumeroAssento(String numeroAssento) {
        this.numeroAssento = numeroAssento;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}

