package com.cinema.site_cinema.controller;

import com.cinema.site_cinema.dto.SalaDTO;
import com.cinema.site_cinema.model.Sala;
import com.cinema.site_cinema.repository.SalaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/salas")
public class SalaController {

    @Autowired
    private SalaRepository salaRepository;

    // Método auxiliar para converter SalaDTO para Sala
    private Sala convertToEntity(SalaDTO salaDTO) {
        Sala sala = new Sala();
        sala.setNumeroSala(salaDTO.getNumeroSala());
        sala.setCapacidade(salaDTO.getCapacidade());
        sala.setTipoExibicao(salaDTO.getTipoExibicao());
        return sala;
    }

    // Endpoint para criar uma nova sala
    @PostMapping
    public ResponseEntity<Sala> criarSala(@RequestBody @Valid SalaDTO salaDTO) {
        Sala sala = convertToEntity(salaDTO);
        Sala salaSalva = salaRepository.save(sala);
        return ResponseEntity.status(HttpStatus.CREATED).body(salaSalva);
    }

    // Endpoint para buscar uma sala por ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarSalaPorId(@PathVariable Integer id) {
        Optional<Sala> sala = salaRepository.findById(id);

        if (sala.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"msg\": \"A Sala não Existe\",  \"erro\":" + HttpStatus.NOT_FOUND.value() + "}");
        }

        return ResponseEntity.ok(sala.get());
    }

    // Endpoint para listar todas as salas
    @GetMapping
    public ResponseEntity<List<Sala>> listarSalas() {
        List<Sala> salas = salaRepository.findAll();
        return ResponseEntity.ok(salas);
    }

    // Endpoint para atualizar uma sala
    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarSala(@PathVariable Integer id, @RequestBody @Valid SalaDTO salaDTO) {
        Optional<Sala> salaOptional = salaRepository.findById(id);

        if (salaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"msg\": \"A Sala não Existe\",  \"erro\":" + HttpStatus.NOT_FOUND.value() + "}");
        }

        Sala sala = salaOptional.get();
        sala.setNumeroSala(salaDTO.getNumeroSala());
        sala.setCapacidade(salaDTO.getCapacidade());
        sala.setTipoExibicao(salaDTO.getTipoExibicao());

        Sala salaAtualizada = salaRepository.save(sala);
        return ResponseEntity.ok(salaAtualizada);
    }

    // Endpoint para deletar uma sala
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarSala(@PathVariable Integer id) {
        Optional<Sala> salaOptional = salaRepository.findById(id);

        if (salaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"msg\": \"A Sala não Existe\",  \"erro\":" + HttpStatus.NOT_FOUND.value() + "}");
        }

        salaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
