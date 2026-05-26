package com.zwinslett.strava.cli;

import com.zwinslett.strava.api.StravaAPIClient;
import com.zwinslett.strava.calculator.ActivityCalculator;
import com.zwinslett.strava.calculator.SplitCalculator;
import com.zwinslett.strava.calculator.ZonesCalculator;
import com.zwinslett.strava.services.ZoneAggregatorService;
import com.fasterxml.jackson.databind.ObjectMapper;

import picocli.CommandLine.Option;

import com.zwinslett.strava.services.ActivityDetailsService;

abstract class BaseCommand {
  protected final StravaAPIClient stravaRequest;
  protected final ActivityCalculator calculator;

  protected final ZoneAggregatorService zoneAggregatorService;
  protected final ActivityDetailsService activityDetailsService;

  @Option(names = { "--json" }, description = "Output results as json")
  protected boolean json;
  protected final ObjectMapper mapper = new ObjectMapper();

  public BaseCommand() {

    this.stravaRequest = new StravaAPIClient();
    try {
      stravaRequest.setAccessToken();
    } catch (Exception e) {
      throw new RuntimeException("Failed:", e);
    }

    ZonesCalculator zoneCalculator = new ZonesCalculator();
    SplitCalculator splitCalculator = new SplitCalculator();

    this.calculator = new ActivityCalculator();

    this.zoneAggregatorService = new ZoneAggregatorService(zoneCalculator, stravaRequest);
    this.activityDetailsService = new ActivityDetailsService(stravaRequest, splitCalculator, calculator);
  }

  protected void printJson(Object data) throws Exception {
    System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data));
  }

}
