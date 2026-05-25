package com.zwinslett.strava.cli;

import java.time.Instant;

import java.util.List;
import java.time.temporal.ChronoUnit;
import picocli.CommandLine.Command;

import com.zwinslett.strava.formatter.ZoneFormatter;

import com.zwinslett.strava.model.DistributionBucketsFormatted;

import com.zwinslett.strava.calculator.ZonesCalculator.ZoneType;

@Command(name = "weekly", description = "Get zones for the last 7 days.")
public class ZonesWeekly extends BaseCommand implements Runnable {

  @Override
  public void run() {
    long epochNow = Instant.now().getEpochSecond();
    long sevenDaysAgo = Instant.now().minus(7, ChronoUnit.DAYS).getEpochSecond();
    try {
      List<DistributionBucketsFormatted> buckets = this.zoneAggregatorService.build(sevenDaysAgo, epochNow,
          ZoneType.heartrate);
      System.out.println(ZoneFormatter.formatZonesTableHeader());
      for (DistributionBucketsFormatted bucket : buckets) {
        System.out.println(ZoneFormatter.formatZoneTableRows(bucket));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
