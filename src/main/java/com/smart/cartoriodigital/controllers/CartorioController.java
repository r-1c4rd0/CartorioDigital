package com.smart.cartoriodigital.controllers;

import com.smart.cartoriodigital.model.Cartorio;
import com.smart.cartoriodigital.repositories.CartorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cartorio")
public class CartorioController {

    @Autowired
    private CartorioRepository repository;

    @GetMapping
    public List<Cartorio> findAll(){
        List <Cartorio> result = repository.findAll();
        return result;
    }
}
