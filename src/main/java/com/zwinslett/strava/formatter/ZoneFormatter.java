package com.zwinslett.strava.formatter;

import com.zwinslett.strava.model.DistributionBucketsFormatted;

public class ZoneFormatter {
    public static String formatZonesTableHeader() {
        String header = String.format("%-10s %-10s %-30s %-10s%n", "Minimum", "Maximum", "Time Spent", "Percent in Zone");
        String divider = "-----------------------------------------------------------------------------------";
        return header + divider;
    }

    public static String formatZoneTableRows(DistributionBucketsFormatted bucket){
        return String.format("%-10d %-10d %-30s %-10.2f%n", bucket.getMin(), bucket.getMax(), bucket.getTime(), bucket.getPercentInZone());
    }
}
