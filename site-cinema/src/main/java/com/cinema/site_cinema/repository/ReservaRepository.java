package com.cinema.site_cinema.repository;

import com.cinema.site_cinema.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

    // Métodos específicos, se necessário
    // Exemplo de método para buscar reserva por nome do cliente
    Reserva findByNomeCliente(String nomeCliente);
}

