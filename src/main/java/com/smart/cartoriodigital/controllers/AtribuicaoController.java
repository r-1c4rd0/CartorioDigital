package com.smart.cartoriodigital.controllers;

import com.smart.cartoriodigital.model.Atribuicao;
import com.smart.cartoriodigital.services.AtribuicaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/atribuicao")
public class AtribuicaoController {

    private final AtribuicaoService atribuicaoService;

    @Autowired
    public AtribuicaoController(AtribuicaoService atribuicaoService) {
        this.atribuicaoService = atribuicaoService;
    }

    @GetMapping
    public ResponseEntity<List<Atribuicao>> getAllAtribuicoes() {
        List<Atribuicao> atribuicoes = atribuicaoService.findAll();
        return ResponseEntity.ok(atribuicoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Atribuicao> getAtribuicaoById(@PathVariable String id) {
        Optional<Atribuicao> atribuicao = atribuicaoService.findById(id);
        return atribuicao.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Atribuicao> createAtribuicao(@RequestBody Atribuicao atribuicao) {
        Atribuicao createdAtribuicao = atribuicaoService.create(atribuicao);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAtribuicao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Atribuicao> updateAtribuicao(@PathVariable String id, @RequestBody Atribuicao atribuicao) {
        Atribuicao updatedAtribuicao = atribuicaoService.update(id, atribuicao);
        if (updatedAtribuicao != null) {
            return ResponseEntity.ok(updatedAtribuicao);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAtribuicao(@PathVariable String id) {
        atribuicaoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
