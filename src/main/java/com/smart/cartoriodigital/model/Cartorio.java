package com.smart.cartoriodigital.model;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Getter
@Setter

public class Cartorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String observacao;
    @OneToMany
    private List<Atribuicao> atribuicoes;
}