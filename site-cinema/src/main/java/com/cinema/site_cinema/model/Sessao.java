package com.cinema.site_cinema.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Sessoes")
public class Sessao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sessao")
    private Integer idSessao;

    @ManyToOne
    @JoinColumn(name = "id_filme", referencedColumnName = "id_filme")
    private Filme filme;

    @ManyToOne
    @JoinColumn(name = "id_sala", referencedColumnName = "id_sala")
    private Sala sala;

    @Column(name = "data_hora")
    private Date dataHora;

    // Construtor com todos os atributos
    public Sessao(Filme filme, Sala sala, Date dataHora) {
        this.filme = filme;
        this.sala = sala;
        this.dataHora = dataHora;
    }

    public Sessao() {
    }

    // getters e setters
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
