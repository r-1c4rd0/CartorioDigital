package com.smart.cartoriodigital.dto;

import ch.qos.logback.core.joran.util.StringToObjectConverter;
import com.smart.cartoriodigital.model.Atribuicao;
import com.smart.cartoriodigital.model.Cartorio;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


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
