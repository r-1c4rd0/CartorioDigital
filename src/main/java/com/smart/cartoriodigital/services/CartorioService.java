package com.smart.cartoriodigital.services;

import com.smart.cartoriodigital.dto.AtribuicaoDTO;
import com.smart.cartoriodigital.dto.CartorioDTO;
import com.smart.cartoriodigital.model.Atribuicao;
import com.smart.cartoriodigital.model.Cartorio;
import com.smart.cartoriodigital.repositories.CartorioRepository;
import org.springframework.stereotype.Service;

@Service
public class CartorioService {

    private CartorioRepository repository;

    public CartorioDTO findById(Integer id){
        Cartorio entity = repository.findById(id).get();
        CartorioDTO dto = new CartorioDTO(entity);// criar construtor em todas as classes dtos
        return dto;
    }
}
