package com.smart.cartoriodigital.model;

import com.smart.cartoriodigital.dto.AtribuicaoDTO;
import lombok.*;
import javax.persistence.*;

@Data
@Entity
public class Atribuicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 20)
    private String id;
    @Column(length = 50)
    private String nome;

    private Boolean situacao;
    public Atribuicao() {

    }

    public Atribuicao(String id, String nome, Boolean situacao) {
        this.id = id;
        this.nome = nome;
        this.situacao = situacao;
    }
    public Atribuicao(AtribuicaoDTO atribuicaoDTO) {
        id = atribuicaoDTO.getId();
        nome = atribuicaoDTO.getNome();
        situacao = atribuicaoDTO.getSituacao();
    }
    public Atribuicao(Atribuicao atribuicao) {
        id = atribuicao.getId();
        nome = atribuicao.getNome();
        situacao = true;
    }


}