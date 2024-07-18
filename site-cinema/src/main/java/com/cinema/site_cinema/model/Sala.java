package com.cinema.site_cinema.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Salas")
public class Sala implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sala")
    private Integer idSala;

    @Column(name = "numero_sala")
    private Integer numeroSala;

    private Integer capacidade;

    @Column(name = "tipo_exibicao")
    private String tipoExibicao;

    // Construtor com todos os atributos
    public Sala(Integer numeroSala, Integer capacidade, String tipoExibicao) {
        this.numeroSala = numeroSala;
        this.capacidade = capacidade;
        this.tipoExibicao = tipoExibicao;
    }

    public Sala() {
    }

    // getters e setters
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

