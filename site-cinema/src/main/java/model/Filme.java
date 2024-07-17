package model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Filme")
public class Filme implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idFilme;

    private String nomeFilme;
    private String sinopse;
    private String elenco;
    private String trailerUrl;
    private Date dataLancamento;
    private boolean emCartaz;


    // Construtor com todos os atributos

    public Filme(String nomeFilme, String sinopse, String elenco, String trailerUrl, Date dataLancamento, boolean emCartaz) {
        this.nomeFilme = nomeFilme;
        this.sinopse = sinopse;
        this.elenco = elenco;
        this.trailerUrl = trailerUrl;
        this.dataLancamento = dataLancamento;
        this.emCartaz = emCartaz;
    }

    public Filme() {

    }

    // getters e setters
    public UUID getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(UUID idFilme) {
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

    public boolean isEmCartaz() {
        return emCartaz;
    }

    public void setEmCartaz(boolean emCartaz) {
        this.emCartaz = emCartaz;
    }
}