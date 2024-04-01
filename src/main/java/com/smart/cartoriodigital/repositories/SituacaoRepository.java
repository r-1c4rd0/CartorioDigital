package com.smart.cartoriodigital.repositories;

import com.smart.cartoriodigital.model.Situacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SituacaoRepository extends JpaRepository<Situacao, String> {
    @Query("SELECT s FROM Situacao s WHERE s.nome = :nome")
    List<Situacao> findSituacoesByNome(@Param("nome") String nome);
}