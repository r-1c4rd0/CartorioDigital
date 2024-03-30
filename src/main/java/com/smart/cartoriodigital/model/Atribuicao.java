package com.smart.cartoriodigital.model;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Getter
@Setter

public class Atribuicao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String nome;
    private Boolean situacao;
}
