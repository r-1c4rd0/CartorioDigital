package com.smart.cartoriodigital.repositories;

import com.smart.cartoriodigital.model.Cartorio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartorioRepository extends JpaRepository<Cartorio, Integer> {
    Optional<Cartorio> findByNome(String nome);
}