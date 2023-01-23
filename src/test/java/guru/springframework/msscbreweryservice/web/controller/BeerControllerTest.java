package guru.springframework.msscbreweryservice.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springframework.msscbreweryservice.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.http.server.reactive.MockServerHttpRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;

import java.util.UUID;


import static org.springframework.http.ResponseEntity.status;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.*;

@WebMvcTest
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @Test
    void getBeerById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/beer" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect((ResultMatcher) status(HttpStatus.OK));
    }

    @Test
    void saveNewBeer() throws Exception {
        BeerDto beerDto = BeerDto.builder().build();
        String beerDtoJson = mapper.writeValueAsString(beerDto);

        mockMvc.perform((RequestBuilder) post("/api/v1/beer/")
                .contentType(MediaType.APPLICATION_JSON).contentType(MediaType.valueOf(beerDtoJson)))
                .andExpect((ResultMatcher) status(HttpStatus.NO_CONTENT));
    }


    @Test
    void updateBeerById() throws Exception {

    }
}