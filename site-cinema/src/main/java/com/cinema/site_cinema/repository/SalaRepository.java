package com.cinema.site_cinema.repository;

import com.cinema.site_cinema.model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Integer> {

    // Métodos específicos, se necessário
    // Exemplo de método para buscar sala por número
    Sala findByNumeroSala(Integer numeroSala);
}

