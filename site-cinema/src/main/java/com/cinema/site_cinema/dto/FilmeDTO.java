package com.cinema.site_cinema.dto;

import java.util.Date;

public class FilmeDTO {

    private Integer idFilme;
    private String nomeFilme;
    private String sinopse;
    private String elenco;
    private String trailerUrl;
    private Date dataLancamento;
    private Boolean emCartaz;

    // Construtores
    public FilmeDTO() {
    }

    public FilmeDTO(Integer idFilme, String nomeFilme, String sinopse, String elenco, String trailerUrl, Date dataLancamento, Boolean emCartaz) {
        this.idFilme = idFilme;
        this.nomeFilme = nomeFilme;
        this.sinopse = sinopse;
        this.elenco = elenco;
        this.trailerUrl = trailerUrl;
        this.dataLancamento = dataLancamento;
        this.emCartaz = emCartaz;
    }

    // Getters e Setters
    public Integer getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Integer idFilme) {
        this.idFilme = idFilme;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getElenco() {
        return elenco;
    }

    public void setElenco(String elenco) {
        this.elenco = elenco;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Boolean getEmCartaz() {
        return emCartaz;
    }

    public void setEmCartaz(Boolean emCartaz) {
        this.emCartaz = emCartaz;
    }
}
