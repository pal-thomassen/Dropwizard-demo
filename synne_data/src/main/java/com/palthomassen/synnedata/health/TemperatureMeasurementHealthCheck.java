package com.palthomassen.synnedata.health;

import com.palthomassen.synnedata.Storage.TemperatureMeasurementStorage;
import com.palthomassen.synnedata.representations.TemperatureMeasurement;
import com.yammer.metrics.core.HealthCheck;

public class TemperatureMeasurementHealthCheck extends HealthCheck {
    private final TemperatureMeasurementStorage temperatureMeasurementStorage;

    public TemperatureMeasurementHealthCheck(TemperatureMeasurementStorage temperatureMeasurementStorage) {
        super("com.palthomassen.synnedata.representations.TemperatureMeasurement");
        this.temperatureMeasurementStorage = temperatureMeasurementStorage;
    }

    @Override
    protected Result check() throws Exception {
        TemperatureMeasurement temperatureMeasurement = new TemperatureMeasurement();
        temperatureMeasurement.setTemperature(37);
        temperatureMeasurementStorage.addTemperatureMeasurement(temperatureMeasurement);

        if (temperatureMeasurementStorage.getTemperatureMeasurementList(20, 50).isEmpty()) {
            return Result.unhealthy("Cannot store temperatureMeasurement");
        } else {
            return Result.healthy();
        }
    }
}