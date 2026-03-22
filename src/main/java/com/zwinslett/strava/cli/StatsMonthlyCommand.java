package com.zwinslett.strava.cli;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import com.zwinslett.strava.formatter.ActivityFormatter;
import com.zwinslett.strava.model.Activity;
import com.zwinslett.strava.model.Stats;

import picocli.CommandLine.Command;

@Command(name = "monthly", description = "Show stats for the last 30 days")
public class StatsMonthlyCommand extends BaseCommand implements Runnable {

    @Override
    public void run() {
        long epochNow = Instant.now().getEpochSecond();
        long thirtyDaysAgo = Instant.now().minus(30, ChronoUnit.DAYS).getEpochSecond();
        try {
            String accessToken = stravaRequest.getAccessToken();
            List<Activity> recentActivityData = stravaRequest.getRangeActivities(accessToken, epochNow, thirtyDaysAgo);
            Stats stats = calculator.calculateStats(recentActivityData);
            System.out.println("In the last 30 days ... \n" + ActivityFormatter.formatActivities(stats));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}