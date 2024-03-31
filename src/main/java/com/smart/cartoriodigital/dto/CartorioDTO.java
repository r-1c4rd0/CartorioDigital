package com.smart.cartoriodigital.dto;

import com.smart.cartoriodigital.model.Atribuicao;
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
}
