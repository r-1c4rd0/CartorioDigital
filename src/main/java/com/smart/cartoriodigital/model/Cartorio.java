package com.smart.cartoriodigital.model;

import com.smart.cartoriodigital.dto.CartorioDTO;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;


@Data
@Entity
public class Cartorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 20)
    private Integer id;
    @Column(length = 150)
    private String nome;
    @Column(length = 250)
    private String observacao;
    @NotNull
    private Boolean situacao;
    @OneToMany
    private List<Atribuicao> atribuicoes;

    public Cartorio(CartorioDTO cartorioDTO) {
        id = cartorioDTO.getId();
        nome = cartorioDTO.getNome();
        observacao = cartorioDTO.getObservacao();
        situacao = cartorioDTO.getSituacao();
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
