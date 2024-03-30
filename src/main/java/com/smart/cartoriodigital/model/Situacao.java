package com.smart.cartoriodigital.model;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Getter
@Setter

public class Situacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String nome;
}
