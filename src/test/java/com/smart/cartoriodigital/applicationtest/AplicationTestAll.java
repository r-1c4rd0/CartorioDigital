package com.smart.cartoriodigital.applicationtest;





import com.smart.cartoriodigital.dto.CartorioDTO;
import com.smart.cartoriodigital.model.Cartorio;
import com.smart.cartoriodigital.repositories.CartorioRepository;
import com.smart.cartoriodigital.services.CartorioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
        import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AplicationTestAll {

    @Mock
    private CartorioRepository cartorioRepository;

    @InjectMocks
    private CartorioService cartorioService;

    @BeforeEach
    void setUp() {
        // Configurações prévias antes de cada teste
    }

    @Test
    public void testFindAll() {
        // Arrange
        List<Cartorio> cartorios = Collections.singletonList(new Cartorio());
        Page<Cartorio> page = new PageImpl<>(cartorios, PageRequest.of(0, 10), cartorios.size());
        when(cartorioRepository.findAll(any(PageRequest.class))).thenReturn(page);

        // Act
        Page<CartorioDTO> result = cartorioService.findAll(PageRequest.of(0, 10));

        // Assert
        assertEquals(cartorios.size(), result.getContent().size());
    }

    @Test
    public void testFindById() {
        // Arrange
        Integer id = 1;
        Cartorio cartorio = new Cartorio();
        cartorio.setId(id);
        when(cartorioRepository.findById(id)).thenReturn(Optional.of(cartorio));

        // Act
        CartorioDTO result = cartorioService.findById(id);

        // Assert
        assertEquals(id, result.getId());
    }


    @Test
    public void testCreate() {
        // Arrange
        CartorioDTO cartorioDTO = new CartorioDTO();
        when(cartorioRepository.save(any(Cartorio.class))).thenReturn(new Cartorio());

        // Act
        CartorioDTO result = cartorioService.create(cartorioDTO);

        // Assert
        assertEquals(cartorioDTO, result);
    }

    @Test
    public void testUpdate() {
        // Arrange
        Integer id = 1;
        CartorioDTO cartorioDTO = new CartorioDTO();
        Cartorio cartorio = new Cartorio();
        cartorio.setId(id);
        when(cartorioRepository.findById(id)).thenReturn(Optional.of(cartorio));
        when(cartorioRepository.save(any(Cartorio.class))).thenReturn(cartorio);

        // Act
        CartorioDTO result = cartorioService.update(id, cartorioDTO);

        // Assert
        assertEquals(id, result.getId());
    }

    @Test
    public void testDelete() {
        // Arrange
        Integer id = 1;
        Cartorio cartorio = new Cartorio();
        cartorio.setId(id);
        when(cartorioRepository.findById(id)).thenReturn(Optional.of(cartorio));

        // Act
        cartorioService.delete(id);

        // Assert
        // Verificar se a exclusão foi realizada com sucesso, por exemplo, através de uma verificação de exceção ou mock de método de exclusão
    }


}
