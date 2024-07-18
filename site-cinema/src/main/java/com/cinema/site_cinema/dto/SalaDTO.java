package com.cinema.site_cinema.dto;

public class SalaDTO {

    private Integer idSala;
    private Integer numeroSala;
    private Integer capacidade;
    private String tipoExibicao;

    // Construtores
    public SalaDTO() {
    }

    public SalaDTO(Integer idSala, Integer numeroSala, Integer capacidade, String tipoExibicao) {
        this.idSala = idSala;
        this.numeroSala = numeroSala;
        this.capacidade = capacidade;
        this.tipoExibicao = tipoExibicao;
    }

    // Getters e Setters
    public Integer getIdSala() {
        return idSala;
    }

    public void setIdSala(Integer idSala) {
        this.idSala = idSala;
    }

    public Integer getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(Integer numeroSala) {
        this.numeroSala = numeroSala;
    }

    public Integer getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(Integer capacidade) {
        this.capacidade = capacidade;
    }

    public String getTipoExibicao() {
        return tipoExibicao;
    }

    public void setTipoExibicao(String tipoExibicao) {
        this.tipoExibicao = tipoExibicao;
    }
}

