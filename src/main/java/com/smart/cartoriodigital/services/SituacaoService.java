package com.smart.cartoriodigital.services;

import com.smart.cartoriodigital.model.Situacao;
import com.smart.cartoriodigital.repositories.SituacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SituacaoService {

    private final SituacaoRepository situacaoRepository;

    @Autowired
    public SituacaoService(SituacaoRepository situacaoRepository) {
        this.situacaoRepository = situacaoRepository;
    }

    public List<Situacao> findAll() {
        return situacaoRepository.findAll();
    }

    public Optional<Situacao> findById(String id) {
        return situacaoRepository.findById(id);
    }

    public Situacao create(Situacao situacao) {
        return situacaoRepository.save(situacao);
    }

    public Situacao update(String id, Situacao situacao) {
        Optional<Situacao> existingSituacaoOptional = situacaoRepository.findById(id);
        if (existingSituacaoOptional.isPresent()) {
            situacao.setId(id);
            return situacaoRepository.save(situacao);
        }
        return null;
    }

    public void delete(String id) {
        situacaoRepository.deleteById(id);
    }
}
