package com.smart.cartoriodigital.model;

import com.smart.cartoriodigital.dto.CartorioDTO;
import lombok.Data;
import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
public class Cartorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String observacao;

    @OneToMany
    private List<Atribuicao> atribuicoes;

    public Cartorio(CartorioDTO cartorioDTO) {
        id = cartorioDTO.getId();
        nome = cartorioDTO.getNome();
        observacao = cartorioDTO.getObservacao();
        if (cartorioDTO.getAtribuicoes() != null) {
            atribuicoes = cartorioDTO.getAtribuicoes().stream()
                    .map(Atribuicao::new)
                    .collect(Collectors.toList());
        }
    }

    public Cartorio() {

    }

    public void updateFromDTO(CartorioDTO cartorioDTO) {
        if (cartorioDTO != null) {
            this.nome = cartorioDTO.getNome();
            this.observacao = cartorioDTO.getObservacao();
        }
    }
}
