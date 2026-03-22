package com.zwinslett.strava.model;

public class Stats {
    private final int totalActivities;
    private final double totalMiles;
    private final double totalMinutes;

    public Stats(int totalActivities, double totalMiles, double totalMinutes) {
        this.totalActivities = totalActivities;
        this.totalMiles = totalMiles;
        this.totalMinutes = totalMinutes;
    }

    public int getTotalActivities() {
        return totalActivities;
    }

    public double getTotalMiles() {
        return totalMiles;
    }

    public double getTotalMinutes() {
        return totalMinutes;
    }

}
