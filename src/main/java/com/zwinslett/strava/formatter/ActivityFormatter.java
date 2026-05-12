package com.zwinslett.strava.formatter;

import com.zwinslett.strava.model.Activity;
import com.zwinslett.strava.model.DetailedActivity;
import com.zwinslett.strava.model.Stats;

public class ActivityFormatter {

  public static String baseFormat(Activity activity, Stats stat) {
    double distance = stat.getTotalMiles();
    double minutes = stat.getTotalMinutes();
    String name = activity.getName();
    return String.format("Name: %s | Distance: %.2f | Minutes: %.2f", name, distance, minutes);
  }

  public static String formatDetailedActivity(DetailedActivity activity, Stats stat) {
    String gearName = activity.getGearName();
    return baseFormat(activity, stat) + " | Gear: " + gearName;
  }

  public static String formatActivity(Activity activity, Stats stat) {
    return baseFormat(activity, stat);
  }

  public static String formatActivities(Stats stat) {
    int totalActivities = stat.getTotalActivities();
    double distance = stat.getTotalMiles();
    double minutes = stat.getTotalMinutes();
    return String.format("Total Activities: %d | Distance: %.2f | Total Minutes: %.2f", totalActivities, distance,
        minutes);
  }
}
