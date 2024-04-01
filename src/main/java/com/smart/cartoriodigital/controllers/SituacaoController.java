package com.smart.cartoriodigital.controllers;

import com.smart.cartoriodigital.model.Situacao;
import com.smart.cartoriodigital.services.SituacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/situacao")
public class SituacaoController {

    private final SituacaoService situacaoService;

    @Autowired
    public SituacaoController(SituacaoService situacaoService) {
        this.situacaoService = situacaoService;
    }

    @GetMapping
    public ResponseEntity<List<Situacao>> getAllSituacoes() {
        List<Situacao> situacoes = situacaoService.findAll();
        return ResponseEntity.ok(situacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Situacao> getSituacaoById(@PathVariable String id) {
        Optional<Situacao> situacao = situacaoService.findById(id);
        return situacao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Situacao> createSituacao(@RequestBody Situacao situacao) {
        Situacao createdSituacao = situacaoService.create(situacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSituacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Situacao> updateSituacao(@PathVariable String id, @RequestBody Situacao situacao) {
        Situacao updatedSituacao = situacaoService.update(id, situacao);
        if (updatedSituacao != null) {
            return ResponseEntity.ok(updatedSituacao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSituacao(@PathVariable String id) {
        try {
            situacaoService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
