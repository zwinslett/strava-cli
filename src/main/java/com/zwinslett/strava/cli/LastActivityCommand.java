package com.zwinslett.strava.cli;

import java.util.List;

import com.zwinslett.strava.calculator.ZonesCalculator.ZoneType;
import com.zwinslett.strava.formatter.ActivityFormatter;
import com.zwinslett.strava.formatter.SplitFormatter;
import com.zwinslett.strava.formatter.ZoneFormatter;
import com.zwinslett.strava.model.Activity;
import com.zwinslett.strava.model.DetailedActivity;
import com.zwinslett.strava.model.Stats;
import com.zwinslett.strava.model.Zones;
import com.zwinslett.strava.model.SplitFormatted;
import com.zwinslett.strava.model.DistributionBucketsFormatted;

import picocli.CommandLine.Command;

@Command(name = "last", description = "Display your most recent activity.")
public class LastActivityCommand extends BaseCommand implements Runnable {

  @Override
  public void run() {
    try {
      List<Activity> activity = stravaRequest.getRecentActivities(1);
      DetailedActivity detailedActivity = stravaRequest.getActivityById(activity.get(0).getId());
      Stats activityData = calculator.calculateStat(detailedActivity);
      List<SplitFormatted> splits = splitCalculator.calculateSplits(detailedActivity);
      List<Zones> zones = stravaRequest.getActivityZones(detailedActivity.getId());
      List<DistributionBucketsFormatted> buckets = zoneCalculator.calculateZones(zones, ZoneType.heartrate);
      System.out.println(ActivityFormatter.formatDetailedActivity(detailedActivity, activityData) + "\n");
      System.out.println("Splits:\n");
      System.out.println(SplitFormatter.formatSplitsTableHeader());
      for (SplitFormatted split : splits) {
        System.out.println(SplitFormatter.formatSplitsTableRows(split));
      }
      System.out.println("\nHeartrate Zones:");
      System.out.println("\n" + ZoneFormatter.formatZonesTableHeader());
      for (DistributionBucketsFormatted bucket : buckets) {
        System.out.println(ZoneFormatter.formatZoneTableRows(bucket));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
