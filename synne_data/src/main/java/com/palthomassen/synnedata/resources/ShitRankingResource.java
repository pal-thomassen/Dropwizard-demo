package com.palthomassen.synnedata.resources;

import com.palthomassen.synnedata.Storage.ShitRankingStorage;
import com.palthomassen.synnedata.representations.ShitMeasurement;
import com.palthomassen.synnedata.representations.ShitRanking;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.List;

@Path("/shit")
@Produces(MediaType.APPLICATION_JSON)
public class ShitRankingResource {

    private final ShitRankingStorage shitRankingStorage;

    public ShitRankingResource(ShitRankingStorage shitRankingStorage) {
        this.shitRankingStorage = shitRankingStorage;
    }

    @GET
    @Path("/all")
    public List<ShitMeasurement> getAllShitMeasurements() {
        return shitRankingStorage.getAllShitMeasurements();
    }

    @POST
    @Path("/add")
    public Response addShitRanking(@Valid ShitMeasurement shitMeasurement) {
        shitRankingStorage.addShitRanking(shitMeasurement);

        return Response.created(UriBuilder.fromResource(ShitRankingResource.class).build()).build();
    }
}
