package com.smart.cartoriodigital.dto;

import com.smart.cartoriodigital.model.Atribuicao;
import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class AtribuicaoDTO {
    private String id;
    private String nome;
    private Boolean situacao;

    public AtribuicaoDTO(){}

    public AtribuicaoDTO(Atribuicao atribuicao) {
        id = atribuicao.getId();
        nome = atribuicao.getNome();;
        situacao = atribuicao.getSituacao();
    }
}
