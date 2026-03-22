package com.zwinslett.strava.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Activity {
    private long id;
    private String name;
    private double distance; // meters
    private int moving_time; // seconds
    private int elapsed_time; // seconds
    private String type;

    public Activity() {
    }

    public Activity(long id, String name, double distance, int moving_time, int elapsed_time,
            String type) {
        this.id = id;
        this.name = name;
        this.distance = distance;
        this.moving_time = moving_time;
        this.elapsed_time = elapsed_time;
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
        return moving_time;
    }

    public int getElapsed_time() {
        return elapsed_time;
    }

    public String getType() {
        return type;
    }
}
