package com.botica.app.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;

@WebM
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void get(){
        mockMvc.perform(get("/producto/listar")).andDo(print())
        client.get().uri("/producto/listar")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk();
    }
}
