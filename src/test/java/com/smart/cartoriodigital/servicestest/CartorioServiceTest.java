package com.smart.cartoriodigital.servicestest;

import com.smart.cartoriodigital.dto.CartorioDTO;
import com.smart.cartoriodigital.exception.CartorioNotFoundException;
import com.smart.cartoriodigital.model.Cartorio;
import com.smart.cartoriodigital.repositories.CartorioRepository;
import com.smart.cartoriodigital.services.CartorioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CartorioServiceTest {

    @Mock
    private CartorioRepository cartorioRepositoryMock;

    @InjectMocks
    private CartorioService cartorioService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll() {
        // Arrange
        Pageable pageable = Pageable.unpaged();
        List<Cartorio> cartorios = new ArrayList<>();
        cartorios.add(new Cartorio());
        Page<Cartorio> cartorioPage = new PageImpl<>(cartorios);
        when(cartorioRepositoryMock.findAll(pageable)).thenReturn(cartorioPage);

        // Act
        Page<CartorioDTO> result = cartorioService.findAll(pageable);

        // Assert
        assertFalse(result.isEmpty());
        assertEquals(cartorios.size(), result.getContent().size());
    }

    @Test
    public void testFindById() {
        // Arrange
        Integer id = 1;
        Cartorio cartorio = new Cartorio();
        when(cartorioRepositoryMock.findById(id)).thenReturn(Optional.of(cartorio));

        // Act
        CartorioDTO result = cartorioService.findById(id);

        // Assert
        assertNotNull(result);
    }

    @Test
    public void testFindByIdNotFound() {
        // Arrange
        Integer id = 1;
        when(cartorioRepositoryMock.findById(id)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(CartorioNotFoundException.class, () -> cartorioService.findById(id));
    }

    @Test
    public void testCreate() {
        // Arrange
        CartorioDTO cartorioDTO = new CartorioDTO();
        when(cartorioRepositoryMock.findByNome(anyString())).thenReturn(Optional.empty());
        when(cartorioRepositoryMock.save(any(Cartorio.class))).thenReturn(new Cartorio());

        // Act
        CartorioDTO result = cartorioService.create(cartorioDTO);

        // Assert
        assertNotNull(result);
    }

    @Test
    public void testUpdate() {
        // Arrange
        Integer id = 1;
        CartorioDTO cartorioDTO = new CartorioDTO();
        when(cartorioRepositoryMock.findById(id)).thenReturn(Optional.of(new Cartorio()));
        when(cartorioRepositoryMock.findByNome(anyString())).thenReturn(Optional.empty());
        when(cartorioRepositoryMock.save(any(Cartorio.class))).thenReturn(new Cartorio());

        // Act
        CartorioDTO result = cartorioService.update(id, cartorioDTO);

        // Assert
        assertNotNull(result);
    }

    @Test
    public void testUpdateNotFound() {
        // Arrange
        Integer id = 1;
        when(cartorioRepositoryMock.findById(id)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(CartorioNotFoundException.class, () -> cartorioService.update(id, new CartorioDTO()));
    }

    @Test
    public void testDelete() {
        // Arrange
        Integer id = 1;
        when(cartorioRepositoryMock.findById(id)).thenReturn(Optional.of(new Cartorio()));
        when(cartorioRepositoryMock.save(any(Cartorio.class))).thenReturn(new Cartorio());

        // Act and Assert
        assertDoesNotThrow(() -> cartorioService.delete(id));
    }

    @Test
    public void testDeleteNotFound() {
        // Arrange
        Integer id = 1;
        when(cartorioRepositoryMock.findById(id)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(CartorioNotFoundException.class, () -> cartorioService.delete(id));
    }
}
