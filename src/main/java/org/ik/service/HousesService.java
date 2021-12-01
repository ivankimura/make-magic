package org.ik.service;

import org.ik.client.HousesClient;
import org.ik.dto.Houses;

import java.time.LocalDateTime;
import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class HousesService {
    String apiKey;
    HousesClient housesClient;
    Optional<Houses> cache;
    LocalDateTime validThru;

    @Inject
    public HousesService(@RestClient HousesClient housesClient,
                         @ConfigProperty(name="app.magic.potter-houses-client-api-key") String apiKey) {
        this.apiKey = apiKey;
        this.housesClient = housesClient;
        this.validThru = LocalDateTime.MIN;
    }


    public Optional<Houses> retrieveHouses() {
        if(LocalDateTime.now().isAfter(validThru)) {
            cache = housesClient.queryHouses(apiKey);
            validThru = LocalDateTime.now();
        }
        return cache;
    }
}
