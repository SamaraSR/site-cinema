package com.cinema.site_cinema.controller;

import com.cinema.site_cinema.dto.FilmeDTO;
import com.cinema.site_cinema.model.Filme;
import com.cinema.site_cinema.repository.FilmeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeRepository filmeRepository;



    // Método auxiliar para converter FilmeDTO para Filme
    private Filme convertToEntity(FilmeDTO filmeDTO) {
        Filme filme = new Filme();
        filme.setNomeFilme(filmeDTO.getNomeFilme());
        filme.setSinopse(filmeDTO.getSinopse());
        filme.setElenco(filmeDTO.getElenco());
        filme.setTrailerUrl(filmeDTO.getTrailerUrl());
        filme.setDataLancamento(filmeDTO.getDataLancamento());
        filme.setEmCartaz(filmeDTO.getEmCartaz());
        filme.setImagemUrl(filmeDTO.getImagemUrl());
        return filme;
    }

    // Endpoint para criar um novo filme
    @PostMapping
    public ResponseEntity<Filme> criarFilme(@RequestBody @Valid FilmeDTO filmeDTO) {
        Filme filme = convertToEntity(filmeDTO);
        Filme filmeSalvo = filmeRepository.save(filme);
        return ResponseEntity.status(HttpStatus.CREATED).body(filmeSalvo);
    }

    // Endpoint para buscar um filme por ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarFilmePorId(@PathVariable Integer id) {
        Optional<Filme> filme = filmeRepository.findById(id);

        if (filme.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"msg\": \"O Filme não Existe\",  \"erro\":" + HttpStatus.NOT_FOUND.value() + "}");
        }

        return ResponseEntity.ok(filme.get());
    }

    // Endpoint para listar todos os filmes
    @GetMapping
    public ResponseEntity<List<Filme>> listarFilmes() {
        List<Filme> filmes = filmeRepository.findAll();
        return ResponseEntity.ok(filmes);
    }

    // Endpoint para atualizar um filme
    @PutMapping("/{id}")
    public ResponseEntity<Filme> atualizarFilme(@PathVariable Integer id, @RequestBody @Valid FilmeDTO filmeDTO) {
        Optional<Filme> filmeOptional = filmeRepository.findById(id);

        if (filmeOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Filme filme = filmeOptional.get();
        filme.setNomeFilme(filmeDTO.getNomeFilme());
        filme.setSinopse(filmeDTO.getSinopse());
        filme.setElenco(filmeDTO.getElenco());
        filme.setTrailerUrl(filmeDTO.getTrailerUrl());
        filme.setDataLancamento(filmeDTO.getDataLancamento());
        filme.setEmCartaz(filmeDTO.getEmCartaz());
        filme.setImagemUrl(filmeDTO.getImagemUrl());

        Filme filmeAtualizado = filmeRepository.save(filme);
        return ResponseEntity.ok(filmeAtualizado);
    }

    // Endpoint para deletar um filme
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFilme(@PathVariable Integer id) {
        if (!filmeRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        filmeRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
