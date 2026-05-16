package com.zwinslett.strava.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DetailedActivity extends Activity {
    @JsonProperty("gear")
    private Gear gear;
    @JsonProperty("splits_standard")
    private List<Split> splits;

    public String getGearName() {
       return gear.getName();
    }

    public List<Split> getSplits(){
        return this.splits;
    }
}
