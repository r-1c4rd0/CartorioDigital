package com.smart.cartoriodigital.controllers;

import com.smart.cartoriodigital.dto.CartorioDTO;
import com.smart.cartoriodigital.exception.CartorioDuplicadoException;
import com.smart.cartoriodigital.exception.CartorioNotFoundException;
import com.smart.cartoriodigital.exception.ReferenciaExternaException;
import com.smart.cartoriodigital.services.CartorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping(value = "/cartorio")
public class CartorioController {

    private final CartorioService cartorioService;

    @Autowired
    public CartorioController(CartorioService cartorioService) {
        this.cartorioService = cartorioService;
    }

    @GetMapping
    public ResponseEntity<Page<CartorioDTO>> getAllCartorios(@RequestParam(defaultValue = "0") int page,
                                                             @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<CartorioDTO> cartorios = cartorioService.findAll(pageable);
        return ResponseEntity.ok(cartorios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartorioDTO> getCartorioById(@PathVariable Integer id) {
        CartorioDTO cartorio = cartorioService.findById(id);
        return ResponseEntity.ok(cartorio);
    }

    @PostMapping
    public ResponseEntity<?> createCartorio(@RequestBody  CartorioDTO cartorioDTO) {
        try {
            CartorioDTO savedCartorio = cartorioService.create(cartorioDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedCartorio);
        } catch (CartorioDuplicadoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCartorio(@PathVariable Integer id, @RequestBody CartorioDTO cartorioDTO) {
        try {
            CartorioDTO updatedCartorio = cartorioService.update(id, cartorioDTO);
            return ResponseEntity.ok(updatedCartorio);
        } catch (CartorioNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (CartorioDuplicadoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCartorio(@PathVariable Integer id) {
        try {
            cartorioService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (CartorioNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (ReferenciaExternaException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
