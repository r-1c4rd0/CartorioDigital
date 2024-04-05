package com.smart.cartoriodigital.controllertest;

import com.smart.cartoriodigital.controllers.CartorioController;
import com.smart.cartoriodigital.dto.CartorioDTO;
import com.smart.cartoriodigital.services.CartorioService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CartorioControllerTest {

    @Mock
    private CartorioService cartorioService;

    @InjectMocks
    private CartorioController cartorioController;

    @Test
    void testGetAllCartorios() {
        // Given
        int page = 0;
        int size = 10;
        Page<CartorioDTO> cartorios = mock(Page.class);
        when(cartorioService.findAll(any())).thenReturn(cartorios);

        // When
        ResponseEntity<Page<CartorioDTO>> response = cartorioController.getAllCartorios(page, size);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(cartorios, response.getBody());
        verify(cartorioService).findAll(any());
    }

    @Test
    void testGetCartorioById() {
        // Given
        Integer id = 1;
        CartorioDTO cartorio = mock(CartorioDTO.class);
        when(cartorioService.findById(id)).thenReturn(cartorio);

        // When
        ResponseEntity<CartorioDTO> response = cartorioController.getCartorioById(id);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(cartorio, response.getBody());
        verify(cartorioService).findById(id);
    }

    @Test
    void testCreateCartorio() {
        // Given
        CartorioDTO cartorioDTO = new CartorioDTO();
        when(cartorioService.create(cartorioDTO)).thenReturn(cartorioDTO);

        // When
        ResponseEntity<?> response = cartorioController.createCartorio(cartorioDTO);

        // Then
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(cartorioDTO, response.getBody());
        verify(cartorioService).create(cartorioDTO);
    }

    @Test
    void testUpdateCartorio() {
        // Given
        Integer id = 1;
        CartorioDTO cartorioDTO = new CartorioDTO();
        when(cartorioService.update(id, cartorioDTO)).thenReturn(cartorioDTO);

        // When
        ResponseEntity<?> response = cartorioController.updateCartorio(id, cartorioDTO);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(cartorioDTO, response.getBody());
        verify(cartorioService).update(id, cartorioDTO);
    }

    @Test
    void testDeleteCartorio() {
        // Given
        Integer id = 1;

        // When
        ResponseEntity<?> response = cartorioController.deleteCartorio(id);

        // Then
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(cartorioService).delete(id);
    }
}

