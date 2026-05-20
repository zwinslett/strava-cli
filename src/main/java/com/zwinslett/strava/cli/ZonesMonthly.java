package com.zwinslett.strava.cli;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.time.temporal.ChronoUnit;
import picocli.CommandLine.Command;

import com.zwinslett.strava.formatter.ZoneFormatter;
import com.zwinslett.strava.model.Activity;
import com.zwinslett.strava.model.DistributionBucketsFormatted;
import com.zwinslett.strava.model.Zones;

@Command(name = "monthly", description = "Get zones for the last 30 days.")
public class ZonesMonthly extends BaseCommand implements Runnable {

    @Override
    public void run() {
        long epochNow = Instant.now().getEpochSecond();
        long thirtyDaysAgo = Instant.now().minus(30, ChronoUnit.DAYS).getEpochSecond();

        try {
            List<Activity> activities = stravaRequest.getRangeActivities(epochNow, thirtyDaysAgo);
            List<Zones> allZones = new ArrayList<>();
            for (Activity activity : activities) {
                List<Zones> zones = stravaRequest.getActivityZones(activity.getId());
                allZones.addAll(zones);
            }
            List<DistributionBucketsFormatted> buckets = zoneCalculator.calculateHeartRateZones(allZones);
            System.out.println(ZoneFormatter.formatZonesTableHeader());
            for (DistributionBucketsFormatted bucket : buckets) {
                System.out.println(ZoneFormatter.formatZoneTableRows(bucket));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
