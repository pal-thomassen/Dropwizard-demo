package com.palthomassen.synnedata.representations;


import org.codehaus.jackson.annotate.JsonProperty;

public class ShitMeasurement {
    @JsonProperty
    private String shape;

    @JsonProperty
    private float amount;

    @JsonProperty
    private ShitRanking ranking;

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public ShitRanking getRanking() {
        return ranking;
    }

    public void setRanking(ShitRanking ranking) {
        this.ranking = ranking;
    }
}