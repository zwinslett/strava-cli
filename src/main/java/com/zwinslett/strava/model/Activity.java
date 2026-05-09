package com.zwinslett.strava.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Activity {
    private long id;
    private String name;
    private double distance; // meters
    @JsonProperty("moving_time")
    private int movingTime; // seconds
    @JsonProperty("elapse_time")
    private int elapsedTime; // seconds
    private String type;

    public Activity() {
    }

    public Activity(long id, String name, double distance, int moving_time, int elapsed_time,
            String type) {
        this.id = id;
        this.name = name;
        this.distance = distance;
        this.movingTime = moving_time;
        this.elapsedTime = elapsed_time;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getDistance() {
        return distance;
    }

    public int getMoving_time() {
        return movingTime;
    }

    public int getElapsed_time() {
        return elapsedTime;
    }

    public String getType() {
        return type;
    }
}
