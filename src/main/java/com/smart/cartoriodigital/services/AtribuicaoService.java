package com.smart.cartoriodigital.services;

import com.smart.cartoriodigital.model.Atribuicao;
import com.smart.cartoriodigital.repositories.AtribuicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtribuicaoService {

    private final AtribuicaoRepository atribuicaoRepository;

    @Autowired
    public AtribuicaoService(AtribuicaoRepository atribuicaoRepository) {
        this.atribuicaoRepository = atribuicaoRepository;
    }

    public List<Atribuicao> findAll() {
        return atribuicaoRepository.findAll();
    }

    public Optional<Atribuicao> findById(String id) {
        return atribuicaoRepository.findById(id);
    }

    public Atribuicao create(Atribuicao atribuicao) {
        return atribuicaoRepository.save(atribuicao);
    }

    public Atribuicao update(String id, Atribuicao atribuicao) {
        Optional<Atribuicao> optionalAtribuicao = atribuicaoRepository.findById(id);
        if (optionalAtribuicao.isPresent()) {
            atribuicao.setId(id);
            return atribuicaoRepository.save(atribuicao);
        } else {
            // Tratar a situação em que a atribuição com o ID especificado não foi encontrada
            return null;
        }
    }

    public void delete(String id) {
        atribuicaoRepository.deleteById(id);
    }

    public List<Atribuicao> findAtribuicoesByNome(String nome) {
        return atribuicaoRepository.findAtribuicoesByNome(nome);
    }
}
