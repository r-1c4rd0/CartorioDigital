package com.smart.cartoriodigital.dto;

import com.smart.cartoriodigital.model.Atribuicao;
import com.smart.cartoriodigital.model.Cartorio;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartorioDTO {
    private Integer id;
    private String nome;
    private String observacao;
    private Boolean situacao;
    private List<Atribuicao> atribuicoes;

    public CartorioDTO(Cartorio cartorio) {
        id = cartorio.getId();
        nome = cartorio.getNome();
        observacao = cartorio.getObservacao();
        situacao = cartorio.getSituacao();
        atribuicoes = cartorio.getAtribuicoes();
    }

    public CartorioDTO (CartorioDTO cartorioDTO) {
        id = cartorioDTO.getId();
        nome = cartorioDTO.getNome();
        observacao = cartorioDTO.getObservacao();
        if (cartorioDTO.getAtribuicoes() != null) {
            // Copia as atribuições, se existirem
            atribuicoes = cartorioDTO.getAtribuicoes().stream()
                    .map(Atribuicao::new)
                    .collect(Collectors.toList());
        }

    }
}
