package com.palthomassen.synnedata.resources;

import com.palthomassen.synnedata.Storage.TemperatureMeasurementStorage;
import com.palthomassen.synnedata.representations.TemperatureMeasurement;
import com.yammer.dropwizard.jersey.params.IntParam;
import com.yammer.metrics.annotation.Timed;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.List;


@Path("/temperatures")
@Produces(MediaType.APPLICATION_JSON)
public class TemperatureResource {
    private final TemperatureMeasurementStorage temperatureMeasurementStorage;

    public TemperatureResource(TemperatureMeasurementStorage temperatureMeasurementStorage) {
        this.temperatureMeasurementStorage = temperatureMeasurementStorage;
    }

    @GET
    @Timed
    public List<TemperatureMeasurement> getTemperatures(
            @QueryParam("lowestTemperature") @DefaultValue("0")IntParam lowestTemperature,
            @QueryParam("highestTemperature") @DefaultValue("40") IntParam highestTemperature ) {

        List<TemperatureMeasurement> measurementList =
                temperatureMeasurementStorage.getTemperatureMeasurementList(lowestTemperature.get(),
                        highestTemperature.get());

        return measurementList;
    }

    @Path("/all")
    @GET
    @Timed
    public float averageTemperature() {
        float total= 0;

        List<TemperatureMeasurement> measurementList = temperatureMeasurementStorage.getAllTemperatureMeasurements();
        for (TemperatureMeasurement temperatureMeasurement: measurementList) {
            total += temperatureMeasurement.getTemperature();
        }
        if (measurementList.isEmpty()) {
            return 0;
        } else {
            return total / measurementList.size();
        }

    }

    @POST
    @Timed
    public Response addTemperatureMeasurement(@Valid TemperatureMeasurement temperatureMeasurement) {
        temperatureMeasurementStorage.addTemperatureMeasurement(temperatureMeasurement);

        return Response.created(UriBuilder.fromResource(TemperatureResource.class).build()).build();
    }

}
