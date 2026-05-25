package com.zwinslett.strava.cli;

import com.zwinslett.strava.api.StravaAPIClient;
import com.zwinslett.strava.calculator.ActivityCalculator;
import com.zwinslett.strava.calculator.SplitCalculator;
import com.zwinslett.strava.calculator.ZonesCalculator;
import com.zwinslett.strava.services.ZoneAggregatorService;

abstract class BaseCommand {
  protected final StravaAPIClient stravaRequest;
  protected final ActivityCalculator calculator;
  protected final SplitCalculator splitCalculator;
  protected final ZonesCalculator zoneCalculator;
  protected final ZoneAggregatorService zoneAggregatorService;

  public BaseCommand() {
    this.stravaRequest = new StravaAPIClient();
    try {
      stravaRequest.setAccessToken();
    } catch (Exception e) {
      throw new RuntimeException("Failed:", e);
    }

    this.calculator = new ActivityCalculator();
    this.splitCalculator = new SplitCalculator();
    this.zoneCalculator = new ZonesCalculator();
    this.zoneAggregatorService = new ZoneAggregatorService(zoneCalculator, stravaRequest);
  }
}
