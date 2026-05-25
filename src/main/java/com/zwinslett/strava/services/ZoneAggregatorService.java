package com.zwinslett.strava.services;

import java.util.ArrayList;
import java.util.List;

import com.zwinslett.strava.calculator.ZonesCalculator;
import com.zwinslett.strava.model.Activity;
import com.zwinslett.strava.model.DistributionBucketsFormatted;
import com.zwinslett.strava.model.Zones;
import com.zwinslett.strava.calculator.ZonesCalculator.ZoneType;
import com.zwinslett.strava.api.StravaAPIClient;

public class ZoneAggregatorService {
  private final ZonesCalculator zoneCalculator;
  private final StravaAPIClient stravaRequest;

  public ZoneAggregatorService(ZonesCalculator zoneCalculator, StravaAPIClient stravaRequest) {
    this.zoneCalculator = zoneCalculator;
    this.stravaRequest = stravaRequest;

  }

  public List<DistributionBucketsFormatted> build(long after, long before, ZoneType zoneType) throws Exception {

    List<Activity> activities = this.stravaRequest.getRangeActivities(before, after);
    List<Zones> allZones = new ArrayList<>();

    for (Activity activity : activities) {
      List<Zones> zones = stravaRequest.getActivityZones(activity.getId());
      allZones.addAll(zones);
    }
    List<DistributionBucketsFormatted> buckets = this.zoneCalculator.calculateZones(allZones, zoneType);

    return buckets;
  }
}
