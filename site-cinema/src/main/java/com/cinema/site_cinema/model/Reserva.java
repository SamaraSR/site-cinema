package com.cinema.site_cinema.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Reservas")
public class Reserva implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Integer idReserva;

    @ManyToOne
    @JoinColumn(name = "id_sessao", referencedColumnName = "id_sessao")
    private Sessao sessao;

    @ManyToOne
    @JoinColumn(name = "id_assento", referencedColumnName = "id_assento")
    private Assento assento;

    @Column(name = "nome_cliente")
    private String nomeCliente;

    @Column(name = "data_reserva")
    private Date dataReserva;

    // Construtor com todos os atributos
    public Reserva(Sessao sessao, Assento assento, String nomeCliente, Date dataReserva) {
        this.sessao = sessao;
        this.assento = assento;
        this.nomeCliente = nomeCliente;
        this.dataReserva = dataReserva;
    }

    public Reserva() {
    }

    // getters e setters
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

