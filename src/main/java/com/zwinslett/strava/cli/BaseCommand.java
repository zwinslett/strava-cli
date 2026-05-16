package com.zwinslett.strava.cli;

import com.zwinslett.strava.api.StravaAPIClient;
import com.zwinslett.strava.calculator.ActivityCalculator;
import com.zwinslett.strava.calculator.SplitCalculator;

abstract class BaseCommand {
    protected final StravaAPIClient stravaRequest;
    protected final ActivityCalculator calculator;
    protected final SplitCalculator splitCalculator;

    public BaseCommand() {
        this.stravaRequest = new StravaAPIClient();
        try {
            stravaRequest.setAccessToken();
        } catch (Exception e) {
            throw new RuntimeException("Failed:", e);
        }

        this.calculator = new ActivityCalculator();
        this.splitCalculator = new SplitCalculator();
    }
}
