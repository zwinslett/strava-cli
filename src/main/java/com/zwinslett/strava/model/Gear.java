package com.zwinslett.strava.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Gear {
    private String id;
    private boolean primary;
    private String name;
    private String nickname;
    @JsonProperty("resource_state")
    private int resourceState;
    private boolean retired;
    private double distance;
    @JsonProperty("converted_distance")
    private double convertedDistance;

    public Gear() {

    }

    public Gear(String id, boolean primary, String name, String nickname, int resourceState, boolean retired,
            double distance, double convertedDistance) {
        this.id = id;
        this.primary = primary;
        this.name = name;
        this.nickname = nickname;
        this.resourceState = resourceState;
        this.retired = retired;
        this.distance = distance;
        this.convertedDistance = convertedDistance;
    }

    public String getId(){
        return this.id;
    }

    public boolean getPrimary(){
        return this.primary;
    }

    public String getName(){
        return this.name;
    }

    public String getNickName(){
        return this.nickname;

    }

    public int getResourceState(){
        return this.resourceState;
    }

    public boolean getRetired(){
        return this.retired;
    }

    public double getDistance(){
        return this.distance;
    }

    public double getConvertedDistance(){
        return this.convertedDistance;
    }

}
