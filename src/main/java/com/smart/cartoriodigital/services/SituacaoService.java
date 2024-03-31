package com.smart.cartoriodigital.services;

import com.smart.cartoriodigital.dto.CartorioDTO;
import com.smart.cartoriodigital.dto.SituacaoDTO;
import com.smart.cartoriodigital.model.Cartorio;
import com.smart.cartoriodigital.model.Situacao;
import com.smart.cartoriodigital.repositories.SituacaoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class SituacaoService {

    private SituacaoRepository repository;

    public SituacaoDTO findById(Integer id) {
        Situacao entity = repository.findById(id).get();
        SituacaoDTO dto = new SituacaoDTO(entity);// criar construtor em todas as classes dtos
        return dto;
    }
}
