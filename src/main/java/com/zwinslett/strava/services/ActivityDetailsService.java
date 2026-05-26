package com.zwinslett.strava.services;

import com.zwinslett.strava.api.StravaAPIClient;
import com.zwinslett.strava.calculator.ActivityCalculator;
import com.zwinslett.strava.calculator.SplitCalculator;
import com.zwinslett.strava.model.DetailedActivity;
import com.zwinslett.strava.model.SplitFormatted;
import com.zwinslett.strava.model.Stats;

import java.util.List;

public class ActivityDetailsService {
  private final StravaAPIClient stravaRequest;
  private final SplitCalculator splitCalculator;
  private final ActivityCalculator activityCalculator;

  public ActivityDetailsService(StravaAPIClient stravaRequest, SplitCalculator splitCalculator,
      ActivityCalculator activityCalculator) {
    this.stravaRequest = stravaRequest;
    this.splitCalculator = splitCalculator;
    this.activityCalculator = activityCalculator;
  }

  public DetailedActivity getDetailedActivity(long activityId) throws Exception {
    return stravaRequest.getActivityById(activityId);
  }

  public List<SplitFormatted> getSplits(DetailedActivity activity) {
    return splitCalculator.calculateSplits(activity);
  }

  public Stats getStats(DetailedActivity activity) {
    return activityCalculator.calculateStat(activity);
  }
}
