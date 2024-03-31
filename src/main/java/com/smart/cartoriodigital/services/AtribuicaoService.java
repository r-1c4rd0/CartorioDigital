package com.smart.cartoriodigital.services;

import com.smart.cartoriodigital.dto.AtribuicaoDTO;
import com.smart.cartoriodigital.model.Atribuicao;
import com.smart.cartoriodigital.repositories.AtribuicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtribuicaoService {

    @Autowired
    private AtribuicaoRepository repository;
    public AtribuicaoDTO findById(Integer id){
        Atribuicao entity = repository.findById(id).get();
        AtribuicaoDTO dto = new AtribuicaoDTO(entity);// criar construtor em todas as classes dtos
        return dto;
    }
}
