package com.cinema.site_cinema.controller;

import com.cinema.site_cinema.dto.AdminDTO;
import com.cinema.site_cinema.model.Admin;
import com.cinema.site_cinema.repository.AdminRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;


import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    // Método auxiliar para converter AdminDTO para Admin
    private Admin convertToEntity(AdminDTO adminDTO) {
        Admin admin = new Admin();
        admin.setNome(adminDTO.getNome());
        admin.setSenha(adminDTO.getSenha());
        return admin;
    }

    // Endpoint para criar um novo admin
    @PostMapping
    public ResponseEntity<Admin> criarAdmin(@RequestBody @Valid AdminDTO adminDTO) {
        Admin admin = convertToEntity(adminDTO);
        Admin adminSalvo = adminRepository.save(admin);
        return ResponseEntity.status(HttpStatus.CREATED).body(adminSalvo);
    }

    // Endpoint para buscar um admin por ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarAdminPorId(@PathVariable Integer id) {
        Optional<Admin> admin = adminRepository.findById(id);

        if (admin.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"msg\": \"O Admin não Existe\",  \"erro\":" + HttpStatus.NOT_FOUND.value() + "}");
        }

        return ResponseEntity.ok(admin.get());
    }

    // Endpoint para listar todos os admins
    @GetMapping
    public ResponseEntity<List<Admin>> listarAdmins() {
        List<Admin> admins = adminRepository.findAll();
        return ResponseEntity.ok(admins);
    }

    // Endpoint para atualizar um admin
    @PutMapping("/{id}")
    public ResponseEntity<Admin> atualizarAdmin(@PathVariable Integer id, @RequestBody @Valid AdminDTO adminDTO) {
        Optional<Admin> adminOptional = adminRepository.findById(id);

        if (adminOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Admin admin = adminOptional.get();
        admin.setNome(adminDTO.getNome());
        admin.setSenha(adminDTO.getSenha());

        Admin adminAtualizado = adminRepository.save(admin);
        return ResponseEntity.ok(adminAtualizado);
    }

    // Endpoint para deletar um admin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAdmin(@PathVariable Integer id) {
        if (!adminRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        adminRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Endpoint para login
    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody @Valid AdminDTO adminDTO) {
        Optional<Admin> adminOptional = adminRepository.findByNomeAndSenha(adminDTO.getNome(), adminDTO.getSenha());

        Map<String, Object> response = new HashMap<>();
        if (adminOptional.isPresent()) {
            response.put("success", true);
            return ResponseEntity.ok(response);
        } else {
            response.put("success", false);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
}
