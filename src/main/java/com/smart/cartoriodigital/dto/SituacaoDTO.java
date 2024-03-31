package com.smart.cartoriodigital.dto;

import com.smart.cartoriodigital.model.Situacao;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class SituacaoDTO {
    private String id;
    private String nome;

    public SituacaoDTO(){

    }
    public SituacaoDTO(Situacao situacao){
        id = situacao.getId();
        nome = situacao.getNome();

    }
}
