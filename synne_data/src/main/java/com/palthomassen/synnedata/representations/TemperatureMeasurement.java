package com.palthomassen.synnedata.representations;

import com.palthomassen.synnedata.utils.CustomJsonDateDeserializer;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import java.util.Date;

public class TemperatureMeasurement {

    @JsonProperty
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date date;

    @JsonProperty
    private int temperature;

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    @JsonProperty
    private String comment;

    public void setDate(Date date) {
        this.date = date;
    }

    public TemperatureMeasurement(){}


    public Date getDate() {
        return date;
    }

    public int getTemperature() {
        return temperature;
    }

    public String getComment() {
        return comment;
    }


}

