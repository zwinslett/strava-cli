package com.zwinslett.strava.model;

public class DistributionBucketsFormatted {
    int min;
    int max;
    double percentInZone;
    String time;

    public DistributionBucketsFormatted() {

    }

    public DistributionBucketsFormatted(int min, int max, double percentInZone, String time) {
        this.min = min;
        this.max = max;
        this.percentInZone = percentInZone;
        this.time = time;
    }

    public int getMin() {
        return this.min;
    }

    public int getMax() {
        return this.max;
    }

    public double getPercentInZone() {
        return this.percentInZone;
    }

    public String getTime() {
        return this.time;
    }

}
