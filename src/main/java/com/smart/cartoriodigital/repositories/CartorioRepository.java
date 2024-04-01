package com.smart.cartoriodigital.repositories;

import com.smart.cartoriodigital.model.Cartorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CartorioRepository extends JpaRepository<Cartorio, Integer> {
    @Query("SELECT c FROM Cartorio c WHERE c.nome = :nome")
    List<Cartorio> findCartoriosByNome(@Param("nome") String nome);
    Optional<Cartorio> findByNome(String nome);
}