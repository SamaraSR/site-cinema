package com.cinema.site_cinema.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Date;

public class FilmeDTO {

    @NotNull(message = "O nome do filme é obrigatório")
    @Size(max = 255, message = "O nome do filme deve ter no máximo 255 caracteres")
    private String nomeFilme;

    private String sinopse;

    private String elenco;

    @Size(max = 255, message = "A URL do trailer deve ter no máximo 255 caracteres")
    private String trailerUrl;

    @NotNull(message = "A data de lançamento é obrigatória")
    private Date dataLancamento;

    @NotNull(message = "O campo 'em cartaz' é obrigatório")
    private Boolean emCartaz;

    @Size(max = 255, message = "A URL da imagem deve ter no máximo 255 caracteres")
    private String imagemUrl;

    // Getters e Setters

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

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }
}
