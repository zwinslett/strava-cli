package com.zwinslett.strava.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Zones {
    private int score;
    @JsonProperty("distribution_buckets")
    private List<DistributionBuckets> distributionBuckets;
    private String type;

    public Zones() {

    }

    public Zones(int score, List<DistributionBuckets> distributionBuckets, String type) {
        this.score = score;
        this.distributionBuckets = distributionBuckets;
        this.type = type;
    }

    public int getScore() {
        return this.score;
    }

    public List<DistributionBuckets> getDistributionBuckets() {
        return this.distributionBuckets;
    }

    public String getType() {
        return this.type;
    }

}
