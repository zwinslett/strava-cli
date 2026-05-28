package com.zwinslett.strava.cli;

import com.zwinslett.strava.formatter.ActivityFormatter;
import com.zwinslett.strava.model.DetailedActivity;
import com.zwinslett.strava.model.Stats;
import java.util.List;
import com.zwinslett.strava.model.SplitFormatted;
import com.zwinslett.strava.model.DistributionBucketsFormatted;
import com.zwinslett.strava.formatter.SplitFormatter;
import com.zwinslett.strava.formatter.ZoneFormatter;
import com.zwinslett.strava.calculator.ZonesCalculator.ZoneType;
import com.zwinslett.strava.model.ActivityReport;

import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "activity", description = "Display a single Strava activity for a given activity ID")

public class ActivityByIdCommand extends BaseCommand implements Runnable {

  @Parameters(index = "0", description = "The ID of the activity to display")
  private long activityId;

  @Override
  public void run() {
    try {
      DetailedActivity detailedActivity = this.activityDetailsService.getDetailedActivity(activityId);
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
