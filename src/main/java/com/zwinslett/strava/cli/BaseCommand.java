package com.zwinslett.strava.cli;
import com.zwinslett.strava.api.StravaAPIClient;
import com.zwinslett.strava.service.ActivityCalculator;

abstract class BaseCommand {
    protected final StravaAPIClient stravaRequest;
    protected final ActivityCalculator calculator;
    public BaseCommand() {
        this.stravaRequest = new StravaAPIClient();
        this.calculator = new ActivityCalculator();
    }
}
