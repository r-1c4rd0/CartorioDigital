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

import java.util.ArrayList;
import java.util.List;
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
    public CartorioDTO create(CartorioDTO cartorio) {
        validateNomeDuplicado(null, cartorio.getNome());
        Cartorio cartorio2 = new Cartorio(cartorio);

        return new CartorioDTO(cartorioRepository.save(cartorio2));
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
            if (cartorio.getAtribuicoes() != null && !cartorio.getAtribuicoes().isEmpty()) {
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

    public List<Cartorio> findCartoriosByNome(String nome) {
        return cartorioRepository.findCartoriosByNome(nome);
    }

    public Optional<Cartorio> findByNome(String nome) {
        return cartorioRepository.findByNome(nome);
    }




    //fins de testes
  /*  @Transactional
    public List<CartorioDTO> createMultiple(List<CartorioDTO> cartoriosDTO) {
        List<CartorioDTO> savedCartoriosDTO = new ArrayList<>();

        for (CartorioDTO cartorioDTO : cartoriosDTO) {
            // Verifica se já existe um cartório com o mesmo ID
            Optional<Cartorio> existingCartorioOptional = cartorioRepository.findById(cartorioDTO.getId());
            if (existingCartorioOptional.isPresent()) {
                throw new CartorioDuplicadoException("Registro já cadastrado com o ID: " + cartorioDTO.getId());
            }

            // Verifica se já existe um cartório com o mesmo nome
            validateNomeDuplicado(null, cartorioDTO.getNome());

            // Converte o DTO para a entidade Cartorio
            Cartorio cartorio = new Cartorio(cartorioDTO);

            // Salva o cartório no repositório
            Cartorio savedCartorio = cartorioRepository.save(cartorio);

            // Adiciona o DTO do cartório salvo à lista de retorno
            savedCartoriosDTO.add(new CartorioDTO(savedCartorio));
        }

        return savedCartoriosDTO;
    }*/

}
