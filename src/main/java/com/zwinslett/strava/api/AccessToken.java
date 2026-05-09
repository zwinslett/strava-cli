package com.zwinslett.strava.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccessToken {
    @JsonProperty("access_token")
    public String accessToken;

    public AccessToken() {

    }

    public AccessToken(String access_token) {
        this.accessToken = access_token;
    }

    public String getToken() {
        return accessToken;
    }

}
