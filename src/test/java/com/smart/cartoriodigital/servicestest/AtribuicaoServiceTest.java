package com.smart.cartoriodigital.servicestest;

import com.smart.cartoriodigital.model.Atribuicao;
import com.smart.cartoriodigital.repositories.AtribuicaoRepository;
import com.smart.cartoriodigital.services.AtribuicaoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AtribuicaoServiceTest {

    @Mock
    private AtribuicaoRepository atribuicaoRepositoryMock;

    @InjectMocks
    private AtribuicaoService atribuicaoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll() {
        // Arrange
        List<Atribuicao> atribuicoes = new ArrayList<>();
        when(atribuicaoRepositoryMock.findAll()).thenReturn(atribuicoes);

        // Act
        List<Atribuicao> result = atribuicaoService.findAll();

        // Assert
        assertEquals(atribuicoes, result);
    }

    @Test
    public void testFindById() {
        // Arrange
        String id = "123";
        Atribuicao atribuicao = new Atribuicao();
        when(atribuicaoRepositoryMock.findById(id)).thenReturn(Optional.of(atribuicao));

        // Act
        Optional<Atribuicao> result = atribuicaoService.findById(id);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(atribuicao, result.get());
    }

    @Test
    public void testCreate() {
        // Arrange
        Atribuicao atribuicao = new Atribuicao();
        when(atribuicaoRepositoryMock.save(atribuicao)).thenReturn(atribuicao);

        // Act
        Atribuicao result = atribuicaoService.create(atribuicao);

        // Assert
        assertEquals(atribuicao, result);
    }

    @Test
    public void testUpdate() {
        // Arrange
        String id = "123";
        Atribuicao atribuicao = new Atribuicao();
        when(atribuicaoRepositoryMock.findById(id)).thenReturn(Optional.of(atribuicao));
        when(atribuicaoRepositoryMock.save(atribuicao)).thenReturn(atribuicao);

        // Act
        Atribuicao result = atribuicaoService.update(id, atribuicao);

        // Assert
        assertNotNull(result);
        assertEquals(id, result.getId());
    }

    @Test
    public void testUpdateNotFound() {
        // Arrange
        String id = "123";
        when(atribuicaoRepositoryMock.findById(id)).thenReturn(Optional.empty());

        // Act
        Atribuicao result = atribuicaoService.update(id, new Atribuicao());

        // Assert
        assertNull(result);
    }

    @Test
    public void testDelete() {
        // Arrange
        String id = "123";

        // Act
        atribuicaoService.delete(id);

        // Assert
        verify(atribuicaoRepositoryMock, times(1)).deleteById(id);
    }
}
