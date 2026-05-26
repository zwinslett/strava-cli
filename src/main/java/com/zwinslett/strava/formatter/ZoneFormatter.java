package com.zwinslett.strava.formatter;

import com.zwinslett.strava.model.DistributionBucketsFormatted;

public class ZoneFormatter {

  private static String secsToMins(int time) {
    int minutes = time / 60;
    int seconds = time % 60;
    return String.format("%d Minute(s) %d Second(s)", minutes, seconds);
  }

  public static String formatZonesTableHeader() {
    String header = String.format("%-10s %-10s %-30s %-10s%n", "Minimum", "Maximum", "Time Spent",
        "Percent in Zone");
    String divider = "-----------------------------------------------------------------------------------";
    return header + divider;
  }

  public static String formatZoneTableRows(DistributionBucketsFormatted bucket) {
    return String.format("%-10d %-10d %-30s %10.3f%%%n", bucket.getMin(), bucket.getMax(), secsToMins(bucket.getTime()),
        bucket.getPercentInZone() * 100);
  }
}
