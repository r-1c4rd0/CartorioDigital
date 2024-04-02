package com.smart.cartoriodigital.model;

import lombok.*;
import javax.persistence.*;

@Data
@Entity
public class Situacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 20)
    private String id;
    @Column(length = 20)
    private String nome;
}