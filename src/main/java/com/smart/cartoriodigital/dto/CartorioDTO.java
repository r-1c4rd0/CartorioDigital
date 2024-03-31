package com.smart.cartoriodigital.dto;

import com.smart.cartoriodigital.model.Atribuicao;
import com.smart.cartoriodigital.model.Cartorio;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class CartorioDTO {
    private Integer id;
    private String nome;
    private String observacao;
    private List<Atribuicao> atribuicoes;

    public CartorioDTO(){

    }

    public CartorioDTO(Cartorio cartorio){
        id = cartorio.getId();
        nome = cartorio.getNome();
        observacao = cartorio.getObservacao();
        atribuicoes = cartorio.getAtribuicoes();

    }
}
