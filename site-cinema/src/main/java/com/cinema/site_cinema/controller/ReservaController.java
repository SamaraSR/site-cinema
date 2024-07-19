package com.cinema.site_cinema.controller;

import com.cinema.site_cinema.dto.ReservaDTO;
import com.cinema.site_cinema.model.Reserva;
import com.cinema.site_cinema.repository.ReservaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    // Método auxiliar para converter ReservaDTO para Reserva
    private Reserva convertToEntity(ReservaDTO reservaDTO) {
        Reserva reserva = new Reserva();
        reserva.setSessao(reservaDTO.getSessao());
        reserva.setAssento(reservaDTO.getAssento());
        reserva.setNomeCliente(reservaDTO.getNomeCliente());
        reserva.setDataReserva(reservaDTO.getDataReserva());
        return reserva;
    }

    // Endpoint para criar uma nova reserva
    @PostMapping
    public ResponseEntity<Reserva> criarReserva(@RequestBody @Valid ReservaDTO reservaDTO) {
        Reserva reserva = convertToEntity(reservaDTO);
        Reserva reservaSalva = reservaRepository.save(reserva);
        return ResponseEntity.status(HttpStatus.CREATED).body(reservaSalva);
    }

    // Endpoint para buscar uma reserva por ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarReservaPorId(@PathVariable Integer id) {
        Optional<Reserva> reserva = reservaRepository.findById(id);

        if (reserva.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"msg\": \"A Reserva não Existe\",  \"erro\":" + HttpStatus.NOT_FOUND.value() + "}");
        }

        return ResponseEntity.ok(reserva.get());
    }

    // Endpoint para listar todas as reservas
    @GetMapping
    public ResponseEntity<List<Reserva>> listarReservas() {
        List<Reserva> reservas = reservaRepository.findAll();
        return ResponseEntity.ok(reservas);
    }

    // Endpoint para atualizar uma reserva
    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarReserva(@PathVariable Integer id, @RequestBody @Valid ReservaDTO reservaDTO) {
        Optional<Reserva> reservaOptional = reservaRepository.findById(id);

        if (reservaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"msg\": \"A Reserva não Existe\",  \"erro\":" + HttpStatus.NOT_FOUND.value() + "}");
        }

        Reserva reserva = reservaOptional.get();
        reserva.setSessao(reservaDTO.getSessao());
        reserva.setAssento(reservaDTO.getAssento());
        reserva.setNomeCliente(reservaDTO.getNomeCliente());
        reserva.setDataReserva(reservaDTO.getDataReserva());

        Reserva reservaAtualizada = reservaRepository.save(reserva);
        return ResponseEntity.ok(reservaAtualizada);
    }

    // Endpoint para deletar uma reserva
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarReserva(@PathVariable Integer id) {
        Optional<Reserva> reservaOptional = reservaRepository.findById(id);

        if (reservaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"msg\": \"A Reserva não Existe\",  \"erro\":" + HttpStatus.NOT_FOUND.value() + "}");
        }

        reservaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
