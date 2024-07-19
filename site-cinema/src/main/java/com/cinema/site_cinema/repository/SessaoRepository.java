package com.cinema.site_cinema.repository;

import com.cinema.site_cinema.model.Sessao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface SessaoRepository extends JpaRepository<Sessao, Integer> {

    // Exemplo de método para buscar sessões por filme
    List<Sessao> findByFilmeIdFilme(int idFilme);

    // Exemplo de método para buscar sessões por sala
    List<Sessao> findBySalaIdSala(Integer idSala);

    // Exemplo de método para buscar sessões por data e hora
    List<Sessao> findByDataHoraAfter(LocalDateTime dataHora);
}

