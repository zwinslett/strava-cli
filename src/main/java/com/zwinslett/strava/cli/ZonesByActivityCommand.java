package com.zwinslett.strava.cli;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import com.zwinslett.strava.formatter.ZoneFormatter;
import com.zwinslett.strava.model.DistributionBucketsFormatted;
import com.zwinslett.strava.model.Zones;
import java.util.List;
import com.zwinslett.strava.calculator.ZonesCalculator.ZoneType;

@Command(name = "activity", description = "Display an activity's zones for a given activity ID")
public class ZonesByActivityCommand extends BaseCommand implements Runnable {
  @Parameters(index = "0", description = "The ID of an activity.")
  private long activityId;

  @Override
  public void run() {
    try {
      List<Zones> zones = stravaRequest.getActivityZones(activityId);
      List<DistributionBucketsFormatted> buckets = zoneCalculator.calculateZones(zones, ZoneType.heartrate);
      System.out.println(ZoneFormatter.formatZonesTableHeader());
      for (DistributionBucketsFormatted bucket : buckets) {
        System.out.println(ZoneFormatter.formatZoneTableRows(bucket));
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
