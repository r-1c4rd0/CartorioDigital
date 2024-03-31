package com.smart.cartoriodigital.repositories;

import com.smart.cartoriodigital.model.Cartorio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartorioRepository extends JpaRepository<Cartorio, Integer> {
}