package com.zwinslett.strava.cli;

import java.time.Instant;
import java.util.List;
import com.zwinslett.strava.formatter.ActivityFormatter;
import com.zwinslett.strava.model.Activity;
import com.zwinslett.strava.model.Stats;
import java.time.temporal.ChronoUnit;

import picocli.CommandLine.Command;

@Command(name = "weekly", description = "Show stats for the last 7 days")
public class StatsWeeklyCommand extends BaseCommand implements Runnable {

  @Override
  public void run() {
    long epochNow = Instant.now().getEpochSecond();
    long sevenDaysAgo = Instant.now().minus(7, ChronoUnit.DAYS).getEpochSecond();
    try {
      List<Activity> recentActivityData = stravaRequest.getRangeActivities(epochNow, sevenDaysAgo);
      Stats stats = calculator.calculateStats(recentActivityData);
      if (json) {
        printJson(stats);
      } else {
        System.out.println("In the last seven days ... \n" + ActivityFormatter.formatActivities(stats));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
