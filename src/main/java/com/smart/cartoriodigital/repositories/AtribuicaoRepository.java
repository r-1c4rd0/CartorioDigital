package com.smart.cartoriodigital.repositories;

import com.smart.cartoriodigital.model.Atribuicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AtribuicaoRepository extends JpaRepository<Atribuicao, String> {
    @Query("SELECT a FROM Atribuicao a WHERE a.nome = :nome")
    List<Atribuicao> findAtribuicoesByNome(@Param("nome") String nome);
}