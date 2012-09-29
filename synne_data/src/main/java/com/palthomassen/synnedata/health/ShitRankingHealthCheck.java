package com.palthomassen.synnedata.health;

import com.palthomassen.synnedata.Storage.ShitRankingStorage;
import com.palthomassen.synnedata.representations.ShitMeasurement;
import com.palthomassen.synnedata.representations.ShitRanking;
import com.yammer.metrics.core.HealthCheck;

public class ShitRankingHealthCheck extends HealthCheck {

    private final ShitRankingStorage shitRankingStorage;

    public ShitRankingHealthCheck(ShitRankingStorage shitRankingStorage) {
        super("com.palthomassen.synnedata.representations.ShitRanking");
        this.shitRankingStorage = shitRankingStorage;
    }

    @Override
    protected Result check() throws Exception {
        ShitMeasurement shitMeasurement = new ShitMeasurement();

        shitMeasurement.setAmount(100);
        shitMeasurement.setRanking(ShitRanking.HOLYCRAP);
        shitMeasurement.setShape("Ball");

        shitRankingStorage.addShitRanking(shitMeasurement);

        if (shitRankingStorage.getAllShitMeasurements().isEmpty()) {
            return Result.unhealthy("Cannot get back shitMeasurement");
        } else {
            return Result.healthy();
        }
    }
}
