package com.cinema.site_cinema.controller;

import com.cinema.site_cinema.dto.SessaoDTO;
import com.cinema.site_cinema.model.Sessao;
import com.cinema.site_cinema.repository.SessaoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sessoes")
public class SessaoController {

    @Autowired
    private SessaoRepository sessaoRepository;

    // Método auxiliar para converter SessaoDTO para Sessao
    private Sessao convertToEntity(SessaoDTO sessaoDTO) {
        Sessao sessao = new Sessao();
        sessao.setFilme(sessaoDTO.getFilme());
        sessao.setSala(sessaoDTO.getSala());
        sessao.setDataHora(sessaoDTO.getDataHora());
        return sessao;
    }

    // Endpoint para criar uma nova sessao
    @PostMapping
    public ResponseEntity<Sessao> criarSessao(@RequestBody @Valid SessaoDTO sessaoDTO) {
        Sessao sessao = convertToEntity(sessaoDTO);
        Sessao sessaoSalva = sessaoRepository.save(sessao);
        return ResponseEntity.status(HttpStatus.CREATED).body(sessaoSalva);
    }

    // Endpoint para buscar uma sessao por ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarSessaoPorId(@PathVariable Integer id) {
        Optional<Sessao> sessao = sessaoRepository.findById(id);

        if (sessao.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"msg\": \"A Sessão não Existe\",  \"erro\":" + HttpStatus.NOT_FOUND.value() + "}");
        }

        return ResponseEntity.ok(sessao.get());
    }

    // Endpoint para listar todas as sessoes
    @GetMapping
    public ResponseEntity<List<Sessao>> listarSessoes() {
        List<Sessao> sessoes = sessaoRepository.findAll();
        return ResponseEntity.ok(sessoes);
    }
}

