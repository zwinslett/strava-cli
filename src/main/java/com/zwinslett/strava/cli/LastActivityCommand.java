package com.zwinslett.strava.cli;

import java.util.List;

import com.zwinslett.strava.calculator.ZonesCalculator.ZoneType;
import com.zwinslett.strava.formatter.ActivityFormatter;
import com.zwinslett.strava.formatter.SplitFormatter;
import com.zwinslett.strava.formatter.ZoneFormatter;
import com.zwinslett.strava.model.Activity;
import com.zwinslett.strava.model.ActivityReport;
import com.zwinslett.strava.model.DetailedActivity;
import com.zwinslett.strava.model.Stats;
import com.zwinslett.strava.model.SplitFormatted;
import com.zwinslett.strava.model.DistributionBucketsFormatted;

import picocli.CommandLine.Command;

@Command(name = "last", description = "Display your most recent activity.")
public class LastActivityCommand extends BaseCommand implements Runnable {

  @Override
  public void run() {
    try {
      List<Activity> activity = stravaRequest.getRecentActivities(1);
      DetailedActivity detailedActivity = this.activityDetailsService.getDetailedActivity(activity.get(0).getId());
      Stats activityData = this.activityDetailsService.getStats(detailedActivity);
      List<SplitFormatted> splits = this.activityDetailsService.getSplits(detailedActivity);
      List<DistributionBucketsFormatted> buckets = this.zoneAggregatorService.build(detailedActivity.getId(),
          ZoneType.heartrate);
      ActivityReport activityReport = new ActivityReport(detailedActivity, buckets);
      if (json) {
        this.printJson(activityReport);
      } else {
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
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
