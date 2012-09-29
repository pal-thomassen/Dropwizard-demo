package com.palthomassen.synnedata.Storage;

import com.palthomassen.synnedata.representations.TemperatureMeasurement;

import java.util.ArrayList;
import java.util.List;

public class TemperatureMeasurementStorage {
    private final List<TemperatureMeasurement> temperatureMeasurementList;

    public TemperatureMeasurementStorage(List<TemperatureMeasurement> temperatureMeasurementList) {
        this.temperatureMeasurementList = temperatureMeasurementList;
    }

    public List<TemperatureMeasurement> getTemperatureMeasurementList(Integer lowestTemperature, Integer highestTemperature) {
        List<TemperatureMeasurement> listWithTemperaturesBetweenArguments = new ArrayList<TemperatureMeasurement>();

        for (TemperatureMeasurement temperatureMeasurement : temperatureMeasurementList) {
            if (temperatureMeasurement.getTemperature() > lowestTemperature && temperatureMeasurement.getTemperature() < highestTemperature) {
                listWithTemperaturesBetweenArguments.add(temperatureMeasurement);
            }
        }
        return listWithTemperaturesBetweenArguments;
    }

    public List<TemperatureMeasurement> getAllTemperatureMeasurements() {
        return this.temperatureMeasurementList;
    }

    public void addTemperatureMeasurement (TemperatureMeasurement temperatureMeasurement) {
        this.temperatureMeasurementList.add(temperatureMeasurement);
    }

}
