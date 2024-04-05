package com.smart.cartoriodigital.repositoriestest;

import com.smart.cartoriodigital.model.Atribuicao;
import com.smart.cartoriodigital.repositories.AtribuicaoRepository;
import com.smart.cartoriodigital.services.AtribuicaoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AtribuicaoRepositoryTest {

    @Mock
    private AtribuicaoRepository atribuicaoRepository;

    @InjectMocks
    private AtribuicaoService atribuicaoService;

    @Test
    public void testFindAtribuicoesByNome() {
        // Arrange
        String nome = "nomeTeste";
        Atribuicao atribuicao = new Atribuicao();
        atribuicao.setNome(nome);
        List<Atribuicao> expectedAtribuicoes = Collections.singletonList(atribuicao);

        // Mocking the behavior of the repository method
        when(atribuicaoRepository.findAtribuicoesByNome(anyString())).thenReturn(expectedAtribuicoes);

        // Act
        List<Atribuicao> result = atribuicaoService.findAtribuicoesByNome(nome);

        // Assert
        assertEquals(expectedAtribuicoes, result);
    }
}
