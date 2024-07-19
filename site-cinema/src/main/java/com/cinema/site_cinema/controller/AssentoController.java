package com.cinema.site_cinema.controller;

import com.cinema.site_cinema.dto.AssentoDTO;
import com.cinema.site_cinema.model.Assento;
import com.cinema.site_cinema.repository.AssentoRepository;
import com.cinema.site_cinema.repository.SalaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/assentos")
public class AssentoController {

    @Autowired
    private AssentoRepository assentoRepository;

    @Autowired
    private SalaRepository salaRepository; // Injeção do repositório da Sala

    // Método auxiliar para converter AssentoDTO para Assento
    private Assento convertToEntity(AssentoDTO assentoDTO) {
        Assento assento = new Assento();
        assento.setIdAssento(assentoDTO.getIdAssento());
        if (assentoDTO.getIdSala() != null) {
            assento.setSala(salaRepository.findById(assentoDTO.getIdSala()).orElse(null));
        }
        assento.setNumeroAssento(assentoDTO.getNumeroAssento());
        assento.setDisponivel(assentoDTO.isDisponivel());
        return assento;
    }

    // Endpoint para criar um novo assento
    @PostMapping
    public ResponseEntity<Assento> criarAssento(@RequestBody @Valid AssentoDTO assentoDTO) {
        Assento assento = convertToEntity(assentoDTO);
        Assento assentoSalvo = assentoRepository.save(assento);
        return ResponseEntity.status(HttpStatus.CREATED).body(assentoSalvo);
    }

    // Endpoint para buscar um assento por ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarAssentoPorId(@PathVariable int id) {
        Optional<Assento> assento = assentoRepository.findById(id);

        if (assento.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"msg\": \"O Assento não Existe\",  \"erro\":" + HttpStatus.NOT_FOUND.value() + "}");
        }

        return ResponseEntity.ok(assento.get());
    }

    // Endpoint para listar todos os assentos
    @GetMapping
    public ResponseEntity<List<Assento>> listarAssentos() {
        List<Assento> assentos = assentoRepository.findAll();
        return ResponseEntity.ok(assentos);
    }

    // Endpoint para atualizar um assento
    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarAssento(@PathVariable int id, @RequestBody @Valid AssentoDTO assentoDTO) {
        Optional<Assento> assentoOptional = assentoRepository.findById(id);

        if (assentoOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"msg\": \"O Assento não Existe\",  \"erro\":" + HttpStatus.NOT_FOUND.value() + "}");
        }

        Assento assento = assentoOptional.get();
        assento.setIdAssento(assentoDTO.getIdAssento());
        if (assentoDTO.getIdSala() != null) {
            assento.setSala(salaRepository.findById(assentoDTO.getIdSala()).orElse(null));
        }
        assento.setNumeroAssento(assentoDTO.getNumeroAssento());
        assento.setDisponivel(assentoDTO.isDisponivel());

        Assento assentoAtualizado = assentoRepository.save(assento);
        return ResponseEntity.ok(assentoAtualizado);
    }

    // Endpoint para deletar um assento
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarAssento(@PathVariable int id) {
        Optional<Assento> assentoOptional = assentoRepository.findById(id);

        if (assentoOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"msg\": \"O Assento não Existe\",  \"erro\":" + HttpStatus.NOT_FOUND.value() + "}");
        }

        assentoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
