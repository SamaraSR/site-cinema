package com.cinema.site_cinema.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Filmes")
public class Filme implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_filme")
    private Integer idFilme;

    @Column(name = "nome_filme", length = 255, nullable = false)
    private String nomeFilme;

    @Column(columnDefinition = "TEXT")
    private String sinopse;

    @Column(columnDefinition = "TEXT")
    private String elenco;

    @Column(name = "trailer_url", length = 255)
    private String trailerUrl;

    @Column(name = "data_lancamento")
    @Temporal(TemporalType.DATE)
    private Date dataLancamento;

    @Column(name = "em_cartaz")
    private Boolean emCartaz;

    @Column(name = "imagem_url", length = 255)
    private String imagemUrl;

    // Construtor com todos os atributos
    public Filme(String nomeFilme, String sinopse, String elenco, String trailerUrl, Date dataLancamento, Boolean emCartaz, String imagemUrl) {
        this.nomeFilme = nomeFilme;
        this.sinopse = sinopse;
        this.elenco = elenco;
        this.trailerUrl = trailerUrl;
        this.dataLancamento = dataLancamento;
        this.emCartaz = emCartaz;
        this.imagemUrl = imagemUrl;
    }

    public Filme() {
    }

    // getters e setters
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

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }
}
