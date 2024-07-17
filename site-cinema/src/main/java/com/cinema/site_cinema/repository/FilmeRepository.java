package com.cinema.site_cinema.repository;

import com.cinema.site_cinema.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, UUID> {
    Filme findByNomeFilme(String nomeFilme);
}
