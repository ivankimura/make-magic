package org.ik.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ik.client.HousesClient;
import org.ik.dto.Houses;
import org.ik.test.LoadFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class HousesServiceTest implements LoadFile {


    private String apiKey;
    private HousesClient housesClient;
    private HousesService fixture;

    @BeforeEach
    void setUp() throws JsonProcessingException {
        housesClient = Mockito.mock(HousesClient.class);
        String houses = loadFile("/data/houses.json");

        //Mockito.when(housesClient.queryHouses(Mockito.anyString())).thenReturn(Optional.of(result));
        Mockito.when(housesClient.queryHouses(Mockito.anyString())).then((invocation) -> {
            return Optional.of(new ObjectMapper().readValue(houses, Houses.class));
        });
        apiKey = "test";
        fixture = new HousesService(housesClient, apiKey);
    }

    @Test
    void shouldRetrieveHouses() {
        Optional<Houses> result = fixture.retrieveHouses();

        Assertions.assertTrue(result.isPresent());


    }

    @Test
    void shouldRetrieveHousesWhenAPIKeyIsNull() {
        fixture = new HousesService(housesClient, null);
        Optional<Houses> result = fixture.retrieveHouses();

        Assertions.assertFalse(result.isPresent());


    }
}