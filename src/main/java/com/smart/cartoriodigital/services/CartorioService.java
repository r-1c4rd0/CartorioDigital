package com.smart.cartoriodigital.services;

import com.smart.cartoriodigital.dto.CartorioDTO;
import com.smart.cartoriodigital.exception.CartorioDuplicadoException;
import com.smart.cartoriodigital.exception.CartorioNotFoundException;
import com.smart.cartoriodigital.exception.ReferenciaExternaException;
import com.smart.cartoriodigital.model.Cartorio;
import com.smart.cartoriodigital.repositories.CartorioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CartorioService {

    private final CartorioRepository cartorioRepository;

    @Autowired
    public CartorioService(CartorioRepository cartorioRepository) {
        this.cartorioRepository = cartorioRepository;
    }

    @Transactional(readOnly = true)
    public Page<CartorioDTO> findAll(Pageable pageable) {
        return cartorioRepository.findAll(pageable)
                .map(CartorioDTO::new);
    }

    @Transactional(readOnly = true)
    public CartorioDTO findById(Integer id) {
        Optional<Cartorio> cartorioOptional = cartorioRepository.findById(id);
        if (cartorioOptional.isPresent()) {
            return new CartorioDTO(cartorioOptional.get());
        } else {
            throw new CartorioNotFoundException("Cartório não encontrado com o ID: " + id);
        }
    }

    @Transactional
    public CartorioDTO create(CartorioDTO cartorioDTO) {
        validateNomeDuplicado(null, cartorioDTO.getNome());
        Cartorio cartorio = new Cartorio(cartorioDTO);
        return new CartorioDTO(cartorioRepository.save(cartorio));
    }

    @Transactional
    public CartorioDTO update(Integer id, CartorioDTO cartorioDTO) {
        Optional<Cartorio> cartorioOptional = cartorioRepository.findById(id);
        if (cartorioOptional.isPresent()) {
            Cartorio existingCartorio = cartorioOptional.get();
            validateNomeDuplicado(existingCartorio.getId(), cartorioDTO.getNome());
            existingCartorio.updateFromDTO(cartorioDTO);
            return new CartorioDTO(cartorioRepository.save(existingCartorio));
        } else {
            throw new CartorioNotFoundException("Cartório não encontrado com o ID: " + id);
        }
    }

    @Transactional
    public void delete(Integer id) {
        Optional<Cartorio> cartorioOptional = cartorioRepository.findById(id);
        if (cartorioOptional.isPresent()) {
            Cartorio cartorio = cartorioOptional.get();
            if (!cartorio.getAtribuicoes().isEmpty()) {
                throw new ReferenciaExternaException("Registro utilizado em outro cadastro.");
            }
            cartorioRepository.delete(cartorio);
        } else {
            throw new CartorioNotFoundException("Cartório não encontrado com o ID: " + id);
        }
    }

    private void validateNomeDuplicado(Integer id, String nome) {
        Optional<Cartorio> cartorioOptional = cartorioRepository.findByNome(nome);
        if (cartorioOptional.isPresent() && !cartorioOptional.get().getId().equals(id)) {
            throw new CartorioDuplicadoException("Nome já informado no registro com código " + cartorioOptional.get().getId());
        }
    }
}
