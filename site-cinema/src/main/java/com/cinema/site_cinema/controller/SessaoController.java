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

    // Endpoint para criar uma nova sessão
    @PostMapping
    public ResponseEntity<Sessao> criarSessao(@RequestBody @Valid SessaoDTO sessaoDTO) {
        Sessao sessao = convertToEntity(sessaoDTO);
        Sessao sessaoSalva = sessaoRepository.save(sessao);
        return ResponseEntity.status(HttpStatus.CREATED).body(sessaoSalva);
    }

    // Endpoint para buscar uma sessão por ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarSessaoPorId(@PathVariable Integer id) {
        Optional<Sessao> sessao = sessaoRepository.findById(id);

        if (sessao.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"msg\": \"A Sessão não Existe\",  \"erro\":" + HttpStatus.NOT_FOUND.value() + "}");
        }

        return ResponseEntity.ok(sessao.get());
    }

    // Endpoint para listar todas as sessões
    @GetMapping
    public ResponseEntity<List<Sessao>> listarSessoes() {
        List<Sessao> sessoes = sessaoRepository.findAll();
        return ResponseEntity.ok(sessoes);
    }

    // Endpoint para atualizar uma sessão
    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarSessao(@PathVariable Integer id, @RequestBody @Valid SessaoDTO sessaoDTO) {
        Optional<Sessao> sessaoOptional = sessaoRepository.findById(id);

        if (sessaoOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"msg\": \"A Sessão não Existe\",  \"erro\":" + HttpStatus.NOT_FOUND.value() + "}");
        }

        Sessao sessao = sessaoOptional.get();
        sessao.setFilme(sessaoDTO.getFilme());
        sessao.setSala(sessaoDTO.getSala());
        sessao.setDataHora(sessaoDTO.getDataHora());

        Sessao sessaoAtualizada = sessaoRepository.save(sessao);
        return ResponseEntity.ok(sessaoAtualizada);
    }

    // Endpoint para deletar uma sessão
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarSessao(@PathVariable Integer id) {
        Optional<Sessao> sessaoOptional = sessaoRepository.findById(id);

        if (sessaoOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"msg\": \"A Sessão não Existe\",  \"erro\":" + HttpStatus.NOT_FOUND.value() + "}");
        }

        sessaoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

