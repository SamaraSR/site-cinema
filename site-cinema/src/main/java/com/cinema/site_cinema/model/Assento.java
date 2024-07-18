package com.cinema.site_cinema.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Assentos")
public class Assento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_assento")
    private Integer idAssento;

    @ManyToOne
    @JoinColumn(name = "id_sala", referencedColumnName = "id_sala")
    private Sala sala;

    @Column(name = "numero_assento")
    private String numeroAssento;

    private Boolean disponivel;

    // Construtor com todos os atributos
    public Assento(Sala sala, String numeroAssento, Boolean disponivel) {
        this.sala = sala;
        this.numeroAssento = numeroAssento;
        this.disponivel = disponivel;
    }

    public Assento() {
    }

    // getters e setters
    public Integer getIdAssento() {
        return idAssento;
    }

    public void setIdAssento(Integer idAssento) {
        this.idAssento = idAssento;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public String getNumeroAssento() {
        return numeroAssento;
    }

    public void setNumeroAssento(String numeroAssento) {
        this.numeroAssento = numeroAssento;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }
}

