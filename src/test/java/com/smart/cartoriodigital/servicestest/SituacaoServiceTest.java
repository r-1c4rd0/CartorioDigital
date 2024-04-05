package com.smart.cartoriodigital.servicestest;

import com.smart.cartoriodigital.model.Situacao;
import com.smart.cartoriodigital.repositories.SituacaoRepository;
import com.smart.cartoriodigital.services.SituacaoService;
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

public class SituacaoServiceTest {

    @Mock
    private SituacaoRepository situacaoRepositoryMock;

    @InjectMocks
    private SituacaoService situacaoService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll() {
        // Arrange
        List<Situacao> situacoes = new ArrayList<>();
        when(situacaoRepositoryMock.findAll()).thenReturn(situacoes);

        // Act
        List<Situacao> result = situacaoService.findAll();

        // Assert
        assertEquals(situacoes, result);
    }

    @Test
    public void testFindById() {
        // Arrange
        String id = "123";
        Situacao situacao = new Situacao();
        when(situacaoRepositoryMock.findById(id)).thenReturn(Optional.of(situacao));

        // Act
        Optional<Situacao> result = situacaoService.findById(id);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(situacao, result.get());
    }

    @Test
    public void testCreate() {
        // Arrange
        Situacao situacao = new Situacao();
        when(situacaoRepositoryMock.save(situacao)).thenReturn(situacao);

        // Act
        Situacao result = situacaoService.create(situacao);

        // Assert
        assertNotNull(result);
    }

    @Test
    public void testUpdate() {
        // Arrange
        String id = "123";
        Situacao situacao = new Situacao();
        when(situacaoRepositoryMock.findById(id)).thenReturn(Optional.of(new Situacao()));
        when(situacaoRepositoryMock.save(situacao)).thenReturn(situacao);

        // Act
        Situacao result = situacaoService.update(id, situacao);

        // Assert
        assertNotNull(result);
    }

    @Test
    public void testUpdateNotFound() {
        // Arrange
        String id = "123";
        when(situacaoRepositoryMock.findById(id)).thenReturn(Optional.empty());

        // Act
        Situacao result = situacaoService.update(id, new Situacao());

        // Assert
        assertNull(result);
    }

    @Test
    public void testDelete() {
        // Arrange
        String id = "123";

        // Act
        assertDoesNotThrow(() -> situacaoService.delete(id));
    }
}

