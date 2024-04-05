package com.smart.cartoriodigital.repositoriestest;

import com.smart.cartoriodigital.model.Cartorio;
import com.smart.cartoriodigital.repositories.CartorioRepository;
import com.smart.cartoriodigital.services.CartorioService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CartorioRepositoryTest {

    @Mock
    private CartorioRepository cartorioRepository;

    @InjectMocks
    private CartorioService cartorioService;

    @Test
    public void testFindCartoriosByNome() {
        // Arrange
        String nome = "nomeTeste";
        Cartorio cartorio = new Cartorio();
        cartorio.setNome(nome);
        List<Cartorio> expectedCartorios = Collections.singletonList(cartorio);

        // Mocking the behavior of the repository method
        when(cartorioRepository.findCartoriosByNome(anyString())).thenReturn(expectedCartorios);

        // Act
        List<Cartorio> result = cartorioService.findCartoriosByNome(nome);

        // Assert
        assertEquals(expectedCartorios, result);
    }

    @Test
    public void testFindByNome() {
        // Arrange
        String nome = "nomeTeste";
        Cartorio cartorio = new Cartorio();
        cartorio.setNome(nome);

        // Mocking the behavior of the repository method
        when(cartorioRepository.findByNome(nome)).thenReturn(Optional.of(cartorio));

        // Act
        Optional<Cartorio> result = cartorioService.findByNome(nome);

        // Assert
        assertEquals(cartorio, result.get());
    }
}

