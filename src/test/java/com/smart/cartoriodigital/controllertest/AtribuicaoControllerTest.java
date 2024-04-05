package com.smart.cartoriodigital.controllertest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smart.cartoriodigital.controllers.AtribuicaoController;
import com.smart.cartoriodigital.model.Atribuicao;
import com.smart.cartoriodigital.services.AtribuicaoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AtribuicaoController.class)
@ExtendWith(SpringExtension.class)
public class AtribuicaoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AtribuicaoService atribuicaoService;

    @InjectMocks
    private AtribuicaoController atribuicaoController;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetAllAtribuicoes() throws Exception {
        List<Atribuicao> atribuicoes = new ArrayList<>();
        atribuicoes.add(new Atribuicao("1", "Atribuicao 1", true));
        atribuicoes.add(new Atribuicao("2", "Atribuicao 2", true));
        when(atribuicaoService.findAll()).thenReturn(atribuicoes);

        mockMvc.perform(get("/atribuicao")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    public void testGetAtribuicaoById() throws Exception {
        Atribuicao atribuicao = new Atribuicao("1", "Atribuicao 1", true);
        when(atribuicaoService.findById("1")).thenReturn(Optional.of(atribuicao));

        mockMvc.perform(get("/atribuicao/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.nome").value("Atribuicao 1"));
    }

    @Test
    public void testCreateAtribuicao() throws Exception {
        Atribuicao atribuicao = new Atribuicao("1", "Atribuicao 1", true);
        when(atribuicaoService.create(any(Atribuicao.class))).thenReturn(atribuicao);

        mockMvc.perform(post("/atribuicao")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(atribuicao)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.nome").value("Atribuicao 1"));
    }

    @Test
    public void testUpdateAtribuicao() throws Exception {
        Atribuicao atribuicao = new Atribuicao("1", "Atribuicao 1", true);
        when(atribuicaoService.update("1", atribuicao)).thenReturn(atribuicao);

        mockMvc.perform(put("/atribuicao/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(atribuicao)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.nome").value("Atribuicao 1"));
    }

    @Test
    public void testDeleteAtribuicao() throws Exception {
        mockMvc.perform(delete("/atribuicao/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}
