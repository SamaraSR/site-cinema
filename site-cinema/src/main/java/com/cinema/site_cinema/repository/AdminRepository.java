package com.cinema.site_cinema.repository;

import com.cinema.site_cinema.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Optional<Admin> findByNomeAndSenha(String nome, String senha);
}


