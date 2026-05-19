package com.zwinslett.strava.model;

public class DistributionBuckets {
    private int min;
    private int max;
    private int time;

    public DistributionBuckets(){

    }

    public DistributionBuckets(int min, int max, int time){
        this.min = min;
        this.max = max;
        this.time = time;
    }

    public int getMin(){
        return this.min;
    }

    public int getMax(){
        return this.max;
    }

    public int getTime(){
        return this.time;
    }

}
