package com.smart.cartoriodigital.repositoriestest;

import com.smart.cartoriodigital.model.Situacao;
import com.smart.cartoriodigital.repositories.SituacaoRepository;
import com.smart.cartoriodigital.services.SituacaoService;
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
public class SituacaoRepositoryTest {

    @Mock
    private SituacaoRepository situacaoRepository;

    @InjectMocks
    private SituacaoService situacaoService;

    @Test
    public void testFindSituacoesByNome() {
        // Arrange
        String nome = "nomeTeste";
        Situacao situacao = new Situacao();
        situacao.setNome(nome);
        List<Situacao> expectedSituacoes = Collections.singletonList(situacao);

        // Mocking the behavior of the repository method
        when(situacaoRepository.findSituacoesByNome(anyString())).thenReturn(expectedSituacoes);

        // Act
        List<Situacao> result = situacaoService.findSituacoesByNome(nome);

        // Assert
        assertEquals(expectedSituacoes, result);
    }
}

