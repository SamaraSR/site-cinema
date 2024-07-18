package com.cinema.site_cinema.repository;

import com.cinema.site_cinema.model.Assento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssentoRepository extends JpaRepository<Assento, Integer> {

    // Métodos específicos, se necessário
    // Exemplo de método para buscar assento por número e sala
    Assento findByNumeroAssentoAndSalaIdSala(String numeroAssento, Integer idSala);
}
