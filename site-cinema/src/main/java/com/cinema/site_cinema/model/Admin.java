package com.cinema.site_cinema.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Admins")
public class Admin implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_admin")
    private Integer idAdmin;

    @Column(name = "nome", length = 255, nullable = false)
    private String nome;

    @Column(name = "senha", length = 255, nullable = false)
    private String senha;

    // Construtor com todos os atributos
    public Admin(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public Admin() {
    }

    // getters e setters
    public Integer getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
