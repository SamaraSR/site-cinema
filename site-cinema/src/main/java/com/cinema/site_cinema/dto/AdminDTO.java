package com.cinema.site_cinema.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AdminDTO {

    @NotNull
    @Size(max = 255)
    private String nome;

    @NotNull
    @Size(max = 255)
    private String senha;

    // getters e setters

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
