package com.cinema.site_cinema.repository;

import com.cinema.site_cinema.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Integer> {


    // Exemplo de método para buscar filme por nome
    Filme findByNomeFilme(String nomeFilme);
}
