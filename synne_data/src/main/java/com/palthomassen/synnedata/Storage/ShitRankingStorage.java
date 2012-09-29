package com.palthomassen.synnedata.Storage;

import com.palthomassen.synnedata.representations.ShitMeasurement;
import com.palthomassen.synnedata.representations.ShitRanking;

import java.util.List;

public class ShitRankingStorage {

    private final List<ShitMeasurement> shitMeasurements;

    public ShitRankingStorage(List<ShitMeasurement> shitMeasurements) {
        this.shitMeasurements = shitMeasurements;
    }

    public List<ShitMeasurement> getAllShitMeasurements() {
        return this.shitMeasurements;
    }

    public void addShitRanking(ShitMeasurement shitMeasurement) {
        this.shitMeasurements.add(shitMeasurement);
    }
}
