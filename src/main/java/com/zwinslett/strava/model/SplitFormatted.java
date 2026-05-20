package com.zwinslett.strava.model;

public class SplitFormatted {
    int mile;
    String movingTime;
    double averageHeartrate;

    public SplitFormatted() {

    }

    public SplitFormatted(int mile, String moving_time, double average_heartrate) {
        this.mile = mile;
        this.movingTime = moving_time;
        this.averageHeartrate = average_heartrate;
    }

    public int getMile() {
        return this.mile;
    }

    public String getMovingTime() {
        return this.movingTime;
    }

    public double getAverageHeartRate() {
        return this.averageHeartrate;
    }

}
