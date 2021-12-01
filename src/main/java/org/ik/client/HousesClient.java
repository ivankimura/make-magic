package org.ik.client;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.ik.dto.Houses;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import java.util.Optional;

@Path("/potterApi")
@RegisterRestClient(configKey="potter-houses-api")
public interface HousesClient {

    @GET
    @Path("/houses")
    public Optional<Houses> queryHouses(@HeaderParam("apiKey")String apiKey);
}