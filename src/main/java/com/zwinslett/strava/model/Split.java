package com.zwinslett.strava.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Split {
    private double distance;
    @JsonProperty("elapsed_time")
    private int elapsedTime;
    @JsonProperty("elevation_difference")
    private double elevationDifference;
    @JsonProperty("moving_time")
    private int movingTime;
    private int split;
    @JsonProperty("average_speed")
    private double averageSpeed;
    @JsonProperty("average_grade_adjusted_speed")
    private double averageGradeAdjustedSpeed;
    @JsonProperty("average_heartrate")
    private double averageHeartrate;
    @JsonProperty("pace_zone")
    private int paceZone;

    public Split() {

    }

    public Split(double distance, int elapsedTime, double elevationDifference, int movingTime, int split,
            double averageSpeed,
            double averageGradeAdjustedSpeed, double averageHeartrate, int paceZone) {
        this.distance = distance;
        this.elapsedTime = elapsedTime;
        this.elevationDifference = elevationDifference;
        this.movingTime = movingTime;
        this.split = split;
        this.averageSpeed = averageSpeed;
        this.averageGradeAdjustedSpeed = averageGradeAdjustedSpeed;
        this.averageHeartrate = averageHeartrate;
        this.paceZone = paceZone;

    }

    public double getDistance() {
        return this.distance;
    }

    public int getElapsedTime() {
        return this.elapsedTime;
    }

    public double getElevationDifference() {
        return this.elevationDifference;
    }

    public int getMovingTime() {
        return this.movingTime;
    }

    public int getSplit() {
        return this.split;
    }

    public double getAverageSpeed() {
        return this.averageSpeed;
    }

    public double getAverageGradeAdjustedSpeed() {
        return this.averageGradeAdjustedSpeed;
    }

    public double getAverageHeartrate() {
        return this.averageHeartrate;
    }

    public int getPaceZone() {
        return this.paceZone;
    }
}
